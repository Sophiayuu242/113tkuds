import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcdSubtraction(a, b);
        int lcm = a * b / gcd;
        System.out.println("LCM: " + lcm);
    }

    static int gcdSubtraction(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcdSubtraction(a - b, b);
        return gcdSubtraction(a, b - a);
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：每次遞迴最多減去 1，最壞情況下最多遞迴 max(a, b) 次。
 */