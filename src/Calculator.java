import java.util.ArrayList;

public class Calculator {
    //속성
    int num1;
    int num2;
    char operator;
    ArrayList<String> resultList = new ArrayList<>();

    //생성자

    //기능
    //계산할 정보 입력(Setter)
    void inputCalc(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    void saveResult(int sum) {
        resultList.add(String.format("%d %c %d = %d", num1, operator, num2, sum));
    }

    void removeResult(){
        resultList.remove(resultList.get(0));
    }

    public void viewResultList(){
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

    //사칙연산 결괏값 반환(Getter)
    public int calculate(){
        int sum = 0;
        boolean error = false;

        // 양의 정수 입력 여부 검사
        if(num1 < 0 || num2 < 0){
            System.out.println("양의 정수를 입력해 주세요");
        }else{
            //사칙연산
            switch (operator) {
                case '+':
                    sum = num1 + num2;
                    break;
                case '-':
                    sum = num1 - num2;
                    break;
                case '*':
                    sum = num1 * num2;
                    break;
                case '/':
                    if(num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                        error = true;
                    }else {
                        sum = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("사칙연산 기호를 정확히 입력해주세요");
                    error = true;
                    break;
            }
            if(error) {
                System.out.println("\nerror가 발생했습니다 숫자와 기호를 정확히 입력해 주세요 (+, -, x, /)");
            }else {
                System.out.println("\n결과 : " + num1 + " " + operator + " " + num2 + " = " + sum);
            }
        }

        return sum;
    }
}
