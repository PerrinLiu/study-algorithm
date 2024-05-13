package study.leetcode.BFirst;

import study.entity.ListNode;

/**
 * b24交换对
 *
 * @author llpy
 * @date 2024/05/07
 */
public class B24SwapPairs {
    // 24. 两两交换链表中的节点 中等
    // 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

    // 示例 1：
    // 输入：head = [1,2,3,4]
    // 输出：[2,1,4,3]

    // 示例 2：
    // 输入：head = []
    // 输出：[]

    // 示例 3：
    // 输入：head = [1]
    // 输出：[1]
    //
    // 提示：
    // 链表中节点的数目在范围 [0, 100] 内
    // 0 <= Node.val <= 100
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode = swapPairs(l1);

        System.out.println(listNode);
        ListNode listNode1 = swapPairs1(l1);

        System.out.println(listNode1);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        int index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                if (head.next != null) {
                    cursor.next = new ListNode(head.next.val);
                    cursor = cursor.next;
                }
                cursor.next = new ListNode(head.val);
                ;
                cursor = cursor.next;
            }
            head = head.next;
            index++;
        }
        return result.next;
    }

    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }
}
