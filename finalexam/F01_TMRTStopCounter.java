import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        String[] stations = new String[n];
        for (int i = 0; i < n; i++) {
            stations[i] = sc.next();
        }
        String start = sc.next();
        String end = sc.next();

        int startIndex = -1, endIndex = -1;
        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) {
                startIndex = i;
            }
            if (stations[i].equals(end)) {
                endIndex = i;
            }
        }

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIndex - endIndex) + 1);
        }
    }
}
/*
 * Time Complexity: O(n)
 * 說明：需掃描陣列一次尋找 start 和 end 站的位置，線性時間。
 */