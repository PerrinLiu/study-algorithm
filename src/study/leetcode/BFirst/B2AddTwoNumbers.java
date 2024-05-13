package study.leetcode.BFirst;

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
 *
 * @author llpy
 * @date 2024/04/20
 */

public class B2AddTwoNumbers {
    // 2.两数相加 中等
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        B2AddTwoNumbers a2AddTwoNumbers2 = new B2AddTwoNumbers();
        ListNode listNode = a2AddTwoNumbers2.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        int c = 0;
        while (l1 != null || l2 != null || c != 0) {
            if (l1 != null) {
                c += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                c += l2.val;
                l2 = l2.next;
            }
            cursor.next = new ListNode(c % 10);
            cursor = cursor.next;
            c = c / 10;
        }
        return result.next;
    }
}
