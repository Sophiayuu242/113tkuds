
public class BSTConversion {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // 1. BST 轉排序雙向鏈結串列（中序遍歷）
    static TreeNode head = null, prev = null;
    public static TreeNode bstToDoublyList(TreeNode root) {
        head = null; prev = null;
        helper(root);
        return head;
    }
    private static void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        helper(node.right);
    }

    // 2. 排序陣列轉平衡 BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length -1);
    }
    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid-1);
        root.right = buildBST(nums, mid+1, right);
        return root;
    }

    // 3. BST 每個節點改為所有大於等於該節點值的節點值總和
    static int sum = 0;
    public static void bstToGreaterSumTree(TreeNode root) {
        sum = 0;
        reverseInOrder(root);
    }
    private static void reverseInOrder(TreeNode node) {
        if (node == null) return;
        reverseInOrder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInOrder(node.left);
    }

    // 輔助：中序遍歷列印
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // 建立範例 BST
        /*
              5
             / \
            3   8
           / \   \
          2   4   10
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(10);

        System.out.println("原BST中序遍歷:");
        printInOrder(root);
        System.out.println();

        // 1. BST轉雙向鏈結串列
        TreeNode head = bstToDoublyList(root);
        System.out.print("BST轉雙向鏈結串列:");
        TreeNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();

        // 2. 排序陣列轉平衡 BST
        int[] sortedArr = {1,2,3,4,5,6,7};
        TreeNode balancedBST = sortedArrayToBST(sortedArr);
        System.out.print("排序陣列轉平衡BST中序遍歷:");
        printInOrder(balancedBST);
        System.out.println();

        // 3. BST轉Greater Sum Tree
        bstToGreaterSumTree(root);
        System.out.print("BST轉Greater Sum Tree中序遍歷:");
        printInOrder(root);
        System.out.println();
    }
}