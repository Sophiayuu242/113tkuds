// TreeSearch.java
import java.util.*;

public class TreeSearch {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }

    // 搜尋指定值 k 是否存在於 BST 中
    static boolean search(TreeNode root, int k) {
        if (root == null) return false;
        if (root.val == k) return true;
        if (k < root.val) return search(root.left, k);
        else return search(root.right, k);
    }

    // 插入節點至 BST（協助建樹用）
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 節點數量
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(); // 插入節點
            root = insert(root, x);
        }

        int k = sc.nextInt(); // 查詢值
        System.out.println(search(root, k));
    }
}