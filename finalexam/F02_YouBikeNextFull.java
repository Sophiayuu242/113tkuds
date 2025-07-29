import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            int hour = Integer.parseInt(parts[0]);
            int min = Integer.parseInt(parts[1]);
            times[i] = hour * 60 + min;
        }

        String[] queryParts = sc.nextLine().split(":");
        int queryTime = Integer.parseInt(queryParts[0]) * 60 + Integer.parseInt(queryParts[1]);

        int index = binarySearch(times, queryTime);
        if (index == -1) {
            System.out.println("No bike");
        } else {
            int result = times[index];
            System.out.printf("%02d:%02d\n", result / 60, result % 60);
        }
    }


    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：用二分搜尋找出第一個大於查詢時間的時刻，時間複雜度為對數階。
 */