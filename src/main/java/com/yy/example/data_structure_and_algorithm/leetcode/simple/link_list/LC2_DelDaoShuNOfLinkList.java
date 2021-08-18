package com.yy.example.data_structure_and_algorithm.leetcode.simple.link_list;

/**
 * Description: 删除链表的倒数第N个节点
 * <pre>
 *  给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *  进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 解题方法：双指针
 *
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-13 at 09:33
 */
public class LC2_DelDaoShuNOfLinkList {

    ListNode head;

    public static void main(String[] args) {

        LC2_DelDaoShuNOfLinkList obj = new LC2_DelDaoShuNOfLinkList();

        // 1 --> 3 --> 4
        ListNode<Integer> l2 = new ListNode<>(1);
        obj.head = l2;
        l2.next = new ListNode<>(3);
        l2.next.next = new ListNode<>(4);
        l2.next.next.next = new ListNode<>(9);
        l2.next.next.next.next = new ListNode<>(100);

        ListNode<Integer> newHead = obj.remove1(2);

        obj.outListNode(newHead);
    }

    private ListNode<Integer> remove1(int n) {
        ListNode<Integer> tmpHead = head;
        ListNode<Integer> first = head;
        ListNode<Integer> second = head;
        for (int i = 1; i < n; i++) {
            first = first.next;
        }

        while (first.next != null){
            first = first.next;
            second = second.next;
        }

        System.out.println("target node data:" + second.data);
        second.data = first.data;
        second.next = first.next;

        return tmpHead;
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
