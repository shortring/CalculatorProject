import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArithmeticCalculator{
    //속성
    double num1;
    double num2;
    char operator;
    ArrayList<String> resultList = new ArrayList<>();
    ArrayList<Double> results = new ArrayList<>();

    //생성자

    //기능
    //계산할 정보 입력(Setter)
    <S> void inputCalc(S num1, S num2, char operator) {
        this.num1 = (double)num1;
        this.num2 = (double)num2;
        this.operator = operator;
    }

    void saveResult(double sum) {
        results.add(sum);
        resultList.add(String.format("%f %c %f = %f", num1, operator, num2, sum));
    }

    void removeResult(){
        resultList.remove(resultList.get(0));
    }

    void viewResultList(){
        int index = 0;
        if(resultList.isEmpty()){
            System.out.println("저장된 기록이 없습니다");
        }else{
            for(String result : resultList){
                index++;
                System.out.println(index + "번째 기록 = " + result);
            }
        }
        System.out.println("-------------------------------------------------");
    }

    void viewBiggestResultsLog(double result){
        List<Double> biggestResultList = results.stream()//스트림 생성
                .filter(biggestValue -> biggestValue > result)  //중간 연산 등록(result보다 더 큰 결괏값 찾기)
                .collect(Collectors.toList());  //최종연산
                //.toList()
        System.out.println("\n저장된 값 중 마지막 결괏값보다 큰 결괏값들 = " + biggestResultList);
    }

    //사칙연산 결괏값 반환(Getter)
    double calculate(){
        double sum = 0;
        boolean error = false;

        // 양의 정수 입력 여부 검사
        if(num1 < 0 || num2 < 0){
            System.out.println("양의 정수를 입력해 주세요");
        }else{
            //사칙연산
            switch (operator) {
                case '+':
                    sum = OperatorType.PLUS.operating(num1, num2);
                    break;
                case '-':
                    sum = OperatorType.MINUS.operating(num1, num2);
                    break;
                case '*':
                    sum = OperatorType.MULTIPLY.operating(num1, num2);
                    break;
                case '/':
                    if(num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                        error = true;
                    }else {
                        sum = OperatorType.DIVIDE.operating(num1, num2);
                    }
                    break;
                case '%':
                    sum = OperatorType.MOD.operating(num1, num2);
                    break;
                case '^':
                    sum = OperatorType.POW.operating(num1, num2);
                    break;
                default:
                    System.out.println("사칙연산 기호를 정확히 입력해주세요");
                    error = true;
                    break;
            }
            if(error) {
                System.out.println("\nerror가 발생했습니다 숫자와 기호를 정확히 입력해 주세요 (+, -, *, /, %, ^)");
            }else {
                //System.out.println("%n결과 : %f %c %f = %f", num1, operator, num2, sum);
                System.out.printf("%n결과 : %f %c %f = %f", num1, operator, num2, sum);
            }
        }

        return sum;
    }
}