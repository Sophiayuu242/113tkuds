public class TreeStatistics {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 計算樹中所有節點值的總和
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    // 2. 找出最大值
    public static int max(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(max(root.left), max(root.right)));
    }

    // 3. 找出最小值
    public static int min(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.data, Math.min(min(root.left), min(root.right)));
    }

    // 4. 計算葉節點的數量
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 5. 計算樹的深度（高度）
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    // 測試主程式
    public static void main(String[] args) {
        /*
                10
               /  \
              5    20
             / \   / \
            3   7 15  30
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(30);

        System.out.println("節點總和: " + sum(root));
        System.out.println("最大值: " + max(root));
        System.out.println("最小值: " + min(root));
        System.out.println("葉節點數量: " + countLeaves(root));
        System.out.println("樹的高度: " + depth(root));
    }
}