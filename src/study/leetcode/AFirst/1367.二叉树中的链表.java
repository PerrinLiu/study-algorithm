/*
 * @lc app=leetcode.cn id=1367 lang=java
 *
 * [1367] 二叉树中的链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

import study.entity.ListNode;
import study.entity.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        TreeNode treeNode = new TreeNode(5, null,
                new TreeNode(2, new TreeNode(4, new TreeNode(6, null, null), null), new TreeNode(1, null, null)));
        System.out.println(treeNode.toString());
        System.out.println(new Solution().isSubPath(l1, treeNode));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isSub(head, root)) {
            return true;
        }
        if (isSubPath(head, root.left)) {
            return true;
        }
        if (isSubPath(head, root.right)) {
            return true;
        }

        // 先判断当前的节点，如果不对，再看左子树和右子树呗
        return false;
    }

    private boolean isSub(ListNode head, TreeNode node) {
        // 特判：链表走完了，返回true
        if (head == null) {
            return true;
        }
        // 特判：链表没走完，树走完了，这肯定不行，返回false
        if (node == null) {
            return false;
        }
        // 如果值不同，必定不是啊
        if (head.val != node.val) {
            return false;
        }
        // 如果值相同，继续看，左边和右边有一个满足即可
        return isSub(head.next, node.left) || isSub(head.next, node.right);
    }

    List<Boolean> list1 = new ArrayList<>();

    public boolean isSubPath1(ListNode head, TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() == 0) {
            return true;
        }
        isSubPathA(root, list, 0);

        return list1.contains(true);
    }

    public void isSubPathA(TreeNode root, List<Integer> list, int tab) {
        if (list1.contains(true)) {
            return;
        }
        if (tab >= list.size()) {
            list1.add(true);
            return;
        }
        if (root == null) {
            return;
        }
        if (root.val == list.get(tab)) {
            tab++;
            isSubPathA(root.left, list, tab);
            isSubPathA(root.right, list, tab);
        }
        if (root.left != null && root.left.val == list.get(1)) {
            isSubPathA(root.left, list, 1);
        }
        if (root.right != null && root.right.val == list.get(1)) {
            isSubPathA(root.right, list, 1);
        }
    }
}
// @lc code=end
