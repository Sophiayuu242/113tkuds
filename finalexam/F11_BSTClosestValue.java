import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        TreeNode root = buildTree(data);
        int T = sc.nextInt();

        int closest = findClosestValue(root, T);
        System.out.println(closest);
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

    static int findClosestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode node = root;
        while (node != null) {
            if (node.val == target) return target;
            if (Math.abs(node.val - target) < Math.abs(closest - target) ||
                (Math.abs(node.val - target) == Math.abs(closest - target) && node.val < closest)) {
                closest = node.val;
            }
            if (target < node.val) node = node.left;
            else node = node.right;
        }
        return closest;
    }
}