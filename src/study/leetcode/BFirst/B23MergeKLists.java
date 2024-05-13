package study.leetcode.BFirst;

import study.entity.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * b23合并klists
 *
 * @author llpy
 * @date 2024/05/05
 */
public class B23MergeKLists {
    // 23. 合并 K 个升序链表 困难
    // 给你一个链表数组，每个链表都已经按升序排列。
    // 请你将所有链表合并到一个升序链表中，返回合并后的链表。
    //
    // 示例 1：
    // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
    // 输出：[1,1,2,3,4,4,5,6]
    // 解释：链表数组如下：
    // [
    // 1->4->5,
    // 1->3->4,
    // 2->6
    // ]
    // 将它们合并到一个有序链表中得到。
    // 1->1->2->3->4->4->5->6

    // 示例 2：
    // 输入：lists = []
    // 输出：[]

    // 示例 3：
    // 输入：lists = [[]]
    // 输出：[]
    //
    // 提示：
    // k == lists.length
    // 0 <= k <= 10^4
    // 0 <= lists[i].length <= 500
    // -10^4 <= lists[i][j] <= 10^4
    // lists[i] 按 升序 排列
    // lists[i].length 的总和不超过 10^4
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(5, new ListNode(8)));
        ListNode l2 = new ListNode(1, new ListNode(6, new ListNode(7)));
        ListNode l3 = new ListNode(3, new ListNode(6, new ListNode(7)));
        ListNode[] listNodes = new ListNode[] { l1, l2, l3 };
        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> tag = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                tag.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(tag);
        ListNode result = new ListNode();
        ListNode cursor = result;
        for (Integer i : tag) {
            cursor.next = new ListNode(i);
            cursor = cursor.next;
        }
        return result.next;
    }
}
