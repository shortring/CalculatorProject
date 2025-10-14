import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num1, num2;
        int sum = 0;

        char operator;
        String startCmd;

        boolean error = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("계산기를 시작하려면 엔터를 누르세요");
            System.out.println("계산기를 종료하고 싶다면 exit를 입력해 주세요");
            startCmd = scanner.nextLine();

            if(startCmd.equals("exit")) {
                break;
            }

            System.out.print("정수를 입력하세요 : ");
            num1 = scanner.nextInt();

            System.out.print("\n계산할 정수를 입력하세요 : ");
            num2 = scanner.nextInt();

            System.out.print("\n사칙연산 기호를 입력하세요(+, -, x, /) : ");
            operator = scanner.next().charAt(0);

            switch (operator) {
                case '+':
                    sum = num1 + num2;
                    break;
                case '-':
                    sum = num1 - num2;
                    break;
                case 'x':
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
                    break;
            }
            if(error) {
                System.out.println("\nerror가 발생했습니다 숫자와 기호를 정확히 입력해 주세요 (+, -, x, /)");
                error = false;
            }else {
                System.out.println("\n결과 : " + num1 + " " + operator + " " + num2 + " = " + sum);
            }
            scanner.nextLine();
        }while(true);
    }
}