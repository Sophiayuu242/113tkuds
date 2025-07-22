public class DigitSum {
    public static int digitSum(int n) {
        if (n < 10) return n;
        return (n % 10) + digitSum(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("digitSum(12345): " + digitSum(12345));
    }
}