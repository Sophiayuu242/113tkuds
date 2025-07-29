import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int diameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        TreeNode root = buildTree(data);
        diameter = 0;
        height(root);
        System.out.println(diameter);
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

    static int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}