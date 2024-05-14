package study.leetcode.AFirst;

import study.entity.ListNode;

/**
 * a19从末端移除第n个
 *
 * @author llpy
 * @date 2024/04/30
 */
public class A19删除链表的倒数第N个结点 {
    // 19. 删除链表的倒数第 N 个结点
    // 中等
    // 提示
    // 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    //
    //
    //
    // 示例 1：
    // 输入：head = [1,2,3,4,5], n = 2
    // 输出：[1,2,3,5]
    //
    // 示例 2：
    // 输入：head = [1], n = 1
    // 输出：[]
    //
    // 示例 3：
    // 输入：head = [1,2], n = 1
    // 输出：[1]
    //
    //
    // 提示：
    // 链表中结点的数目为 sz
    // 1 <= sz <= 30
    // 0 <= Node.val <= 100
    // 1 <= n <= sz
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode listNode = removeNthFromEnd(l1, 2);
        System.out.println(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode();
        ListNode cursor = listNode;
        if (head == null) {
            return listNode.next;
        }
        int i = 0;
        while (head != null) {
            i++;
            cursor.next = new ListNode(head.val);
            cursor = cursor.next;
            head = head.next;
        }
        int tag = i - n;
        ListNode result = new ListNode();
        cursor = result;
        listNode = listNode.next;
        while (listNode != null) {
            if (tag-- != 0) {
                cursor.next = new ListNode(listNode.val);
                cursor = cursor.next;
            }
            listNode = listNode.next;
        }

        return result.next;
    }
}
