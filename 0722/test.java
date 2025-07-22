class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) { this.data = data; }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class test {

    // 題目 1：最大公因數
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 題目 2：檢查陣列是否升序
    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) return true;
        if (arr[index] > arr[index + 1]) return false;
        return isSorted(arr, index + 1);
    }

    // 題目 3：數字各位數總和
    public static int digitSum(int n) {
        if (n < 10) return n;
        return (n % 10) + digitSum(n / 10);
    }

    // 題目 4：費波納契數列
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 題目 5：二元樹中序走訪
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // 題目 6：鏈結串列反向列印
    public static void printReverse(ListNode head) {
        if (head == null) return;
        printReverse(head.next);
        System.out.print(head.val + " ");
    }

    // 題目 7：費波納契數列的複雜度比較
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }}
