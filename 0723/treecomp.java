import java.util.*;

public class treecomp {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }

    // 建立二元樹（使用 level-order 輸入，null 用 -1 表示）
    static TreeNode buildTree(String[] tokens) {
        if (tokens.length == 0 || tokens[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < tokens.length) {
            TreeNode curr = q.poll();
            if (!tokens[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(curr.left);
            }
            i++;
            if (i < tokens.length && !tokens[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // 比較兩棵樹是否相同
    static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tree1 = sc.nextLine().split(" ");
        String[] tree2 = sc.nextLine().split(" ");
        TreeNode t1 = buildTree(tree1);
        TreeNode t2 = buildTree(tree2);
        System.out.println(isSame(t1, t2) ? "true" : "false");
    }
}