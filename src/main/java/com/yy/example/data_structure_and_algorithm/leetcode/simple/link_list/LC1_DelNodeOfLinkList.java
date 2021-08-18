package com.yy.example.data_structure_and_algorithm.leetcode.simple.link_list;

/**
 * Description: 删除链表中的节点
 * <pre>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 *
 * 示例 1：
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2：
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-13 at 09:33
 */
public class LC1_DelNodeOfLinkList {

    ListNode head;

    public static void main(String[] args) {

        LC1_DelNodeOfLinkList obj = new LC1_DelNodeOfLinkList();

        // 1 --> 3 --> 4
        ListNode<Integer> l2 = new ListNode<>(1);
        obj.head = l2;
        l2.next = new ListNode<>(3);
        l2.next.next = new ListNode<>(4);

        obj.remove1(l2);

        obj.outListNode(obj.head);
    }

    private void remove1(ListNode<Integer> nodeOfRemove) {
        if(nodeOfRemove.next == null) {
            return;
        }
        nodeOfRemove.data = nodeOfRemove.next.data;
        nodeOfRemove.next = nodeOfRemove.next.next;
    }

    private void remove2(ListNode<Integer> nodeOfRemove) {
        if(nodeOfRemove.data.equals(head.data)){
            head = head.next;
        }else {
            ListNode<Integer> pre = head;
            ListNode<Integer> cur = head.next;
            while (cur != null) {
                ListNode<Integer> next = cur.next;
                if(cur.data.equals(nodeOfRemove.data)) {
                    pre.next = next;
                    return;
                }

                pre = cur;
                cur = next;
            }
        }
    }

    private void outListNode(ListNode<Integer> node) {
        int i = 0;
        while (node != null) {
            System.out.println("index:" + i + " data:" + node.data);
            node = node.next;
            i ++;
        }
    }

    public static class ListNode<T>{
        T data;
        ListNode<T> next;

        public ListNode() {
        }

        public ListNode(T data) {
            this.data = data;
        }
    }
}
