import java.util.Scanner;

public class FactorialExampleinput {

    public static String factorialWithSteps(int n) {
        StringBuilder steps = new StringBuilder();
        int result = 1;

        for (int i = n; i >= 1; i--) {
            result *= i;
            steps.append(i);
            if (i > 1) {
                steps.append("*");
            }
        }

        steps.append("=").append(result);
        return steps.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // 要求輸入正整數
        while (true) {
            System.out.print("請輸入一個正整數：");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("錯誤：必須是大於 0 的正整數！");
                }
            } else {
                System.out.println("錯誤：請輸入整數！");
                scanner.next(); // 清除非整數的輸入
            }
        }

        System.out.println(n + "! = " + factorialWithSteps(n));
        scanner.close();
    }
}