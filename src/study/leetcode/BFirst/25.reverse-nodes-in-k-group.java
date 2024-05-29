/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30202
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (67.93%)
 * Likes:    2332
 * Dislikes: 0
 * Total Accepted:    606.5K
 * Total Submissions: 892.2K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 
 * 
 * 
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * 
 * 
 * 
 * 
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import study.entity.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        // ListNode l1 = new ListNode(1,
        // new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(new Solution().reverseKGroup1(l1, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        while (head != null) {
            ListNode node = dfs(head, k);
            while (node != null) {
                cursor.next = new ListNode(node.val);
                cursor = cursor.next;
                node = node.next;
            }
            int number = k;
            while (number-- != 0 && head != null) {
                head = head.next;
            }
        }
        return result.next;
    }

    private ListNode dfs(ListNode head, int number) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        while (number != 0 && head != null) {
            Integer val = dfs1(head, --number);
            if (val == null) {
                return head;
            }
            cursor.next = new ListNode(val);
            cursor = cursor.next;
        }
        return result.next;
    }

    private Integer dfs1(ListNode head, int number) {
        if (head == null) {
            return null;
        }
        if (number > 0) {
            return dfs1(head.next, --number);
        }
        return head.val;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newhead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newhead;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,5]\n3\n
 * // @lcpr case=end
 * 
 */
