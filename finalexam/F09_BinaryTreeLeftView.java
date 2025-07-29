import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        TreeNode root = buildTree(input);
        printLeftView(root);
    }

    static TreeNode buildTree(String[] data) {
        if (data.length == 0 || data[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < data.length) {
            TreeNode current = queue.poll();
            if (i < data.length && !data[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < data.length && !data[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    static void printLeftView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print("LeftView:");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    System.out.print(" " + node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        System.out.println();
    }
}