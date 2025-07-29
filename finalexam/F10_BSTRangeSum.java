import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        TreeNode root = buildTree(data);
        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSumBST(root, L, R);
        System.out.println(sum);
    }

    static TreeNode buildTree(String[] data) {
        if (data.length == 0 || data[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < data.length) {
            TreeNode node = queue.poll();
            if (i < data.length && !data[i].equals("-1")) {
                node.left = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(node.left);
            }
            i++;
            if (i < data.length && !data[i].equals("-1")) {
                node.right = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R); // 全部左子樹都小於L
        if (root.val > R) return rangeSumBST(root.left, L, R);  // 全部右子樹都大於R
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}