import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /**
         * 1. 두 수를 입력받는다
         * 2. 사칙연산 기호를 입력받는다
         * 3. 계산한다.
         * 4. 계산한 값을 저장하고 꺼내볼 수 있게 한다.
         * 5. 계산기 프로그램을 종료하고 싶다면 exit를 입력 /그렇지않다면 엔터를 눌러서 계속 계산할 수 있게 한다.
         * 6. 지금까지 계산한 값들의 기록을 확인하고 싶다면 view를 입력한다 -> 가장 처음에 기록되었던 값을 삭제하고 싶다면 delete를 입력한다
         * 7. 계산이 완료되면 결괏값과 지금까지 계산한 값들 중에서 그 결괏값보다 큰 계산값들을 함께 보여준다.
         */

        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        Double num1 = null, num2 = null;
        double sum = 0;
        char operator = ' ';
        String startCmd;

        try{
            do {
                System.out.println("계산기를 시작하려면 엔터를 누르세요");
                System.out.println("계산기를 종료하고 싶다면 exit를 입력해 주세요");
                System.out.println("저장된 기록을 확인하고 싶다면 view를 입력해 주세요");

                startCmd = scanner.nextLine();

                switch (startCmd) {
                    case "exit":
                        break;
                    case "view":
                        calculator.viewResultList();
                        System.out.println("데이터를 삭제하고 싶다면 delete를, 그렇지 않다면 엔터를 입력해주세요");
                        if(scanner.nextLine().equals("delete")) {
                            calculator.removeResult();
                        }
                        break;
                    default:
                        System.out.print("계산할 첫번째 정수를 입력해주세요 : ");
                        num1 = scanner.nextDouble();

                        System.out.print("\n계산할 두번째 정수를 입력해주세요 : ");
                        num2 = scanner.nextDouble();

                        System.out.print("\n사칙연산 기호를 입력하세요(+, -, *, /) : ");
                        operator = scanner.next().charAt(0);

                        calculator.inputCalc(num1, num2, operator);
                        sum = calculator.calculate();
                        BigDecimal fixedResult = new BigDecimal(sum);
                        calculator.saveResult(fixedResult.doubleValue());
                        scanner.nextLine(); //scanner.nextLine()으로 인한 (exit입력 혹은 계산기 시작 입력)을 넘기는 문제 해결을 위해 추가
                        break;
                }
            }while(true);
        }catch(Exception e){
            System.out.println("정확한 값을 입력해주세요(+, -, *, /) " + e.getMessage());
        }

    }
}