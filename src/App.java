import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int num1, num2;
        int sum = 0;

        char operator;
        String startCmd;

        do {
            System.out.println("계산기를 시작하려면 엔터를 누르세요");
            System.out.println("계산기를 종료하고 싶다면 exit를 입력해 주세요");
            System.out.println("저장된 기록을 확인하고 싶다면 view를 입력해 주세요");

            startCmd = scanner.nextLine();

            switch (startCmd) {
                case "exit":
                    break;
                case "delete":
                    calculator.removeResult();
                    break;
                case "view":
                    calculator.viewResult();
                    System.out.println("데이터를 삭제하고 싶다면 delete를, 그렇지 않다면 엔터를 입력해주세요");
                    if(scanner.nextLine().equals("delete")) {
                        calculator.removeResult();
                    }
                    break;
                default:
                    System.out.print("정수를 입력하세요 : ");
                    num1 = scanner.nextInt();

                    System.out.print("\n계산할 정수를 입력하세요 : ");
                    num2 = scanner.nextInt();

                    System.out.print("\n사칙연산 기호를 입력하세요 : ");
                    operator = scanner.next().charAt(0);

                    //사칙연산
                    calculator.settingCalc(num1, num2, operator);
                    calculator.calculate();
                    scanner.nextLine(); //scanner.nextLine()으로 인한 (exit입력 혹은 계산기 시작 입력)을 넘기는 문제 해결을 위해 추가
                    break;
            }


        }while(true);

    }
}