import java.util.*;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int[] result = findSecondMax(A, 0, n - 1);
        System.out.println("SecondMax: " + result[1]);
    }

    static int[] findSecondMax(int[] A, int left, int right) {
        if (left == right) {
            return new int[]{A[left], Integer.MIN_VALUE};
        }

        int mid = (left + right) / 2;
        int[] leftPair = findSecondMax(A, left, mid);
        int[] rightPair = findSecondMax(A, mid + 1, right);

        int max, second;

        if (leftPair[0] > rightPair[0]) {
            max = leftPair[0];
            second = Math.max(leftPair[1], rightPair[0]);
        } else if (leftPair[0] < rightPair[0]) {
            max = rightPair[0];
            second = Math.max(rightPair[1], leftPair[0]);
        } else {
            max = leftPair[0];
            second = Math.max(leftPair[1], rightPair[1]);
        }

        return new int[]{max, second};
    }
}

/*
 * Time Complexity: O(n)
 * 說明：遞迴將陣列二分，每一層合併結果僅需常數時間，共需處理 n 個元素。
 */