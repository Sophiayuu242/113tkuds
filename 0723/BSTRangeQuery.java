import java.util.ArrayList;

public class BSTRangeQuery {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 範圍查詢：遞迴中序遍歷 + 篩選範圍
    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRange(root, min, max, result);
        return result;
    }

    // 協助函數：中序遍歷（左 -> 根 -> 右）會自然遞增
    private static void inOrderRange(TreeNode node, int min, int max, ArrayList<Integer> list) {
        if (node == null) return;

        if (node.data > min) {
            inOrderRange(node.left, min, max, list);
        }

        if (node.data >= min && node.data <= max) {
            list.add(node.data);
        }

        if (node.data < max) {
            inOrderRange(node.right, min, max, list);
        }
    }

    public static void main(String[] args) {
        /*
                20
               /  \
             10    30
            / \    / \
           5  15  25  35
        */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        ArrayList<Integer> result = rangeQuery(root, 12, 27);
        System.out.println("範圍 [12, 27] 中的節點值: " + result);
    }
}