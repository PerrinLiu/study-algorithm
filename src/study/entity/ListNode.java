package study.entity;

/**
 * 列表节点
 *
 * @author llpy
 * @date 2024/04/20
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                val +
                ", next=" + next +
                '}';
    }
}