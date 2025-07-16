import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int[] prefix = new int[k];
        prefix[0] = results[0];

        for (int i = 1; i < k; i++) {
            prefix[i] = prefix[i - 1] + results[i];
        }

        System.out.print("PrefixSum:");
        for (int i = 0; i < k; i++) {
            System.out.print(" " + prefix[i]);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(k)
 * 說明：
 * 前綴陣列建立僅需遍歷前 k 項資料，故為 O(k)
 * 輸出也為 O(k)，總體時間複雜度為 O(k)
 */