import java.util.*;

public class ul6compare {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 建立樹（層序）
    static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < nodes.length) {
            TreeNode curr = queue.poll();
            if (!nodes[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // 比較兩棵樹是否完全相同
    static boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] t1Input = sc.nextLine().split(" ");
        String[] t2Input = sc.nextLine().split(" ");
        TreeNode t1 = buildTree(t1Input);
        TreeNode t2 = buildTree(t2Input);
        System.out.println(isSame(t1, t2) ? "Equal" : "Not equal");
    }
}