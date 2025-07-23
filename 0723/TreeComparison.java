import java.util.*;

public class TreeComparison {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // 判斷兩棵樹是否完全相同
    public static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    // 判斷 tree 是否是 subtree 的子樹
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 找兩樹最大公共子樹節點數（結構和值完全相同）
    public static int maxCommonSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return 0;
        int max = Math.max(maxCommonSubtree(root1.left, root2), maxCommonSubtree(root1.right, root2));
        if (isSame(root1, root2)) {
            int size = subtreeSize(root1);
            max = Math.max(max, size);
        }
        return max;
    }

    // 計算子樹節點數
    private static int subtreeSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + subtreeSize(root.left) + subtreeSize(root.right);
    }

    // 輔助：層序建立樹，null 用 -1 表示
    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            TreeNode curr = q.poll();
            if (!nodes[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(curr.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tree1 = sc.nextLine().split(" ");
        String[] tree2 = sc.nextLine().split(" ");
        TreeNode root1 = buildTree(tree1);
        TreeNode root2 = buildTree(tree2);

        System.out.println("是否完全相同: " + isSame(root1, root2));
        System.out.println("是否子樹: " + isSubtree(root1, root2));
        System.out.println("最大公共子樹節點數: " + maxCommonSubtree(root1, root2));
    }
}