import java.util.Scanner;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        for (int i = 0; i < Math.min(n, 5); i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        int limit = Math.min(n, 5);
        for (int i = 0; i < limit; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)外層最多跑 5 次（找出前 5 大），內層最多 n 次
 * 因此總比較次數為 5n，仍屬 O(n^2) 等級的選擇排序
 */