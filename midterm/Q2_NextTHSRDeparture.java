import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 吃掉換行

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            times[i] = parseTimeToMinutes(time);
        }

        String query = sc.nextLine();
        int queryMin = parseTimeToMinutes(query);

        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryMin) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No train");
        } else {
            int minutes = times[ans];
            int hour = minutes / 60;
            int min = minutes % 60;
            System.out.printf("%02d:%02d\n", hour, min);
        }
    }

    static int parseTimeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

/*
 * Time Complexity: O(log n)將查詢轉換為分鐘數為 O(1)對已排序的時間陣列使用 binary search，時間為 O(log n)
 * 其他處理皆為常數時間或 O(n)
 */