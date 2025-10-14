import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1, num2;
        int sum = 0;

        char operator;
        String startCmd;

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

            System.out.print("\n사칙연산 기호를 입력하세요 : ");
            operator = scanner.next().charAt(0);

            Calculator calculator = new Calculator(num1, num2, operator);
            scanner.nextLine();
        }while(true);
    }
}