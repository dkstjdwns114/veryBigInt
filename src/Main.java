import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculate calculate = new Calculate();
        String result;

        while(true){
            System.out.println("프로그램종료 : exit 입력");
            System.out.print("수식을 입력하세요 : ");
            String formula = sc.nextLine();

            if(formula.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            calculate.ClassifyNum(formula);
            String[] str = formula.split("\\*");
            String num1 = str[0];
            String num2 = str[1];
            System.out.print(num1 + " * " + num2  + " = ");
            result = calculate.mulNum(num1, num2);
            System.out.print(result + "\n");
            String commaResult = calculate.comma(result);
            System.out.println("천단위 콤마찍기 : " + commaResult);
            System.out.println();
        }
    }
}
