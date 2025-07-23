import java.util.*;

// 樹節點類別
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) {
        val = v;
    }
}

// 雙向鏈結串列節點類別
class ListNode {
    int val;
    ListNode prev, next;
    ListNode(int v) {
        val = v;
    }
}

public class btree07 {
    // 將二元搜尋樹轉為升冪排序的雙向鏈結串列
    public static ListNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        List<ListNode> list = new ArrayList<>();
        inOrder(root, list);

        // 把 List 連成雙向鏈結串列
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) list.get(i).prev = list.get(i - 1);
            if (i < list.size() - 1) list.get(i).next = list.get(i + 1);
        }

        return list.get(0); // 回傳頭節點
    }

    // 中序走訪，把節點轉為 ListNode 加入 list 中
    private static void inOrder(TreeNode root, List<ListNode> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(new ListNode(root.val));
        inOrder(root.right, list);
    }

    // 測試程式
    public static void main(String[] args) {
        /*
                4
               / \
              2   6
             / \   \
            1   3   7
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        ListNode head = bstToDoublyList(root);
        System.out.print("雙向鏈結串列（正向）: ");
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            if (cur.next == null) break;
            cur = cur.next;
        }

        System.out.print("\n雙向鏈結串列（反向）: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.prev;
        }
    }
}