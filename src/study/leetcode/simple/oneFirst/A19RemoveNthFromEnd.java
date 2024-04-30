package study.leetcode.simple.oneFirst;

import study.TimingTemplate;
import study.entity.ListNode;

import java.util.List;

/**
 * a19从末端移除第n个
 *
 * @author llpy
 * @date 2024/04/30
 */
public class A19RemoveNthFromEnd {
    //    19. 删除链表的倒数第 N 个结点
//    提示
//    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
//    示例 1：
//    输入：head = [1,2,3,4,5], n = 2
//    输出：[1,2,3,5]
//
//    示例 2：
//    输入：head = [1], n = 1
//    输出：[]
//
//    示例 3：
//    输入：head = [1,2], n = 1
//    输出：[1]
//
//
//    提示：
//    链表中结点的数目为 sz
//            1 <= sz <= 30
//            0 <= Node.val <= 100
//            1 <= n <= sz
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        System.out.println(removeNthFromEnd(l1, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode();
        ListNode cursor = listNode;
        int i = 0;
        while(head.next!=null){
            i++;
            cursor = head.next;
        }

        return head;
    }
}



