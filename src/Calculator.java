import java.util.Scanner;

public class Calculator {
    //속성
    int num1;
    int num2;
    int sum;
    char operator;

    //생성자
//    Calculator(int num1, int num2, char operator){
//        this.num1 = num1;
//        this.num2 = num2;
//        this.operator = operator;
//        sum = calculate(this.num1, this.num2, this.operator);
//    }

    //기능
    public int calculate(int num1, int num2, char operator){
        sum = 0;
        boolean error = false;
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
                error = true;
                break;
        }
        if(error) {
            System.out.println("\nerror가 발생했습니다 숫자와 기호를 정확히 입력해 주세요 (+, -, x, /)");
        }else {
            System.out.println("\n결과 : " + num1 + " " + operator + " " + num2 + " = " + sum);
        }

        return sum;
    }
}
