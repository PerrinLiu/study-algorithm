package study.leetcode.simple;

import study.entity.ListNode;

/**
 * 合并两个列表21
 *
 * @author llpy
 * @date 2024/04/20
 */
public class mergeTwoLists21 {
    //    21. 合并两个有序链表
//            简单
//    相关标签
//            相关企业
//    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
//    示例 1：
//
//
//    输入：l1 = [1,2,4], l2 = [1,3,4]
//    输出：[1,1,2,3,4,4]
//    示例 2：
//
//    输入：l1 = [], l2 = []
//    输出：[]
//    示例 3：
//
//    输入：l1 = [], l2 = [0]
//    输出：[0]
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(5, new ListNode(8)));
        ListNode l2 = new ListNode(1, new ListNode(6, new ListNode(7)));
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode.toString());
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


}
