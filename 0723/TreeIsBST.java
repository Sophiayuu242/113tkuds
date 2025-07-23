
import java.util.*;

public class TreeIsBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }

    // 建立樹（層序輸入，-1 表示空節點）
    public static TreeNode buildTree(Scanner sc) {
        int n = sc.nextInt();
        if (n == 0) return null;

        TreeNode[] nodes = new TreeNode[n];
        boolean[] isChild = new boolean[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            if (l != -1) {
                nodes[i].left = nodes[l];
                isChild[l] = true;
            }
            if (r != -1) {
                nodes[i].right = nodes[r];
                isChild[r] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!isChild[i]) return nodes[i];
        }
        return null;
    }

    // 判斷是否為合法 BST
    public static boolean isBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 遞迴輔助：確認區間是否合法
    private static boolean isBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);
        System.out.println(isBST(root) ? "true" : "false");
    }
}