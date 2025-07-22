public class FactorialExample1 {

    // 回傳結果包含計算過程與數值
    public static String factorialWithSteps(int n) {
        if (n < 0) {
            return "錯誤：n 不能小於 0";
        }
        StringBuilder steps = new StringBuilder();
        int result = 1;

        for (int i = n; i >= 1; i--) {
            result *= i;
            steps.append(i);
            if (i > 1) {
                steps.append("*");
            }
        }

        if (n == 0) {
            steps.append("1");
        }

        steps.append("=").append(result);
        return steps.toString();
    }

    public static void main(String[] args) {
        System.out.println("3! = " + factorialWithSteps(3)); // 輸出：3*2*1=6
        System.out.println("5! = " + factorialWithSteps(5)); // 輸出：5*4*3*2*1=120
        System.out.println("0! = " + factorialWithSteps(0)); // 輸出：1=1
    }
}
