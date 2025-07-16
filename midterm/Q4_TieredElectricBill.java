import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bills = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            int amount = calc(kWh);
            bills[i] = amount;
            total += amount;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Bill: $" + bills[i]);
        }

        int avg = (int) Math.round((double) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    static int calc(int k) {
        int sum = 0;
        int[] limits = {120, 210, 170, 200, 300}; // 分段用電量
        double[] prices = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};

        int[] blocks = new int[6];
        int remain = k;

        for (int i = 0; i < 5; i++) {
            if (remain > limits[i]) {
                blocks[i] = limits[i];
                remain -= limits[i];
            } else {
                blocks[i] = remain;
                remain = 0;
                break;
            }
        }
        blocks[5] = remain;

        for (int i = 0; i < 6; i++) {
            sum += Math.round(blocks[i] * prices[i]);
        }

        return sum;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 每筆用電量使用固定段數計算，為 O(1)
 * 總共處理 n 筆輸入，總時間為 O(n)
 */