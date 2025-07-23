import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // 用哈希表快速找到中序序列中節點位置
    static Map<Integer, Integer> inOrderIndexMap;

    // 依前序與中序重建樹
    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inOrderIndexMap.get(rootVal);
        int leftSize = inRootIndex - inStart;

        root.left = buildPreIn(preorder, preStart + 1, preStart + leftSize, inStart, inRootIndex - 1);
        root.right = buildPreIn(preorder, preStart + leftSize + 1, preEnd, inRootIndex + 1, inEnd);
        return root;
    }

    // 依後序與中序重建樹
    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inOrderIndexMap.get(rootVal);
        int leftSize = inRootIndex - inStart;

        root.left = buildPostIn(postorder, postStart, postStart + leftSize -1, inStart, inRootIndex -1);
        root.right = buildPostIn(postorder, postStart + leftSize, postEnd -1, inRootIndex +1, inEnd);
        return root;
    }

    // 前序遍歷印出
    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    // 中序遍歷印出
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 範例輸入格式：
        // n (節點數)
        // preorder序列 (空白分隔)
        // inorder序列 (空白分隔)
        // postorder序列 (空白分隔)
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        int[] postorder = new int[n];

        for (int i=0; i<n; i++) preorder[i] = sc.nextInt();
        for (int i=0; i<n; i++) inorder[i] = sc.nextInt();
        for (int i=0; i<n; i++) postorder[i] = sc.nextInt();

        TreeNode rootPreIn = buildTreePreIn(preorder, inorder);
        TreeNode rootPostIn = buildTreePostIn(postorder, inorder);

        System.out.print("前序+中序重建樹的前序遍歷: ");
        printPreOrder(rootPreIn);
        System.out.println();

        System.out.print("前序+中序重建樹的中序遍歷: ");
        printInOrder(rootPreIn);
        System.out.println();

        System.out.print("後序+中序重建樹的前序遍歷: ");
        printPreOrder(rootPostIn);
        System.out.println();

        System.out.print("後序+中序重建樹的中序遍歷: ");
        printInOrder(rootPostIn);
        System.out.println();
    }
}