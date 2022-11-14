package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_2_linklist;

/**
 * Description: 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/fv6w7/
 * </pre>
 */
public class LC11_AddTwoNumberLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        int adder = 0;
        while (l1 != null && l2 != null) {
            int count = l1.val + l2.val + adder;
            if(count - 10 >= 0) {
                dummy.next = new ListNode(count - 10);
                adder = 1;
            }else {
                dummy.next = new ListNode(count);
                adder = 0;
            }
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if(adder == 1) {
                if(l1.val + adder - 10 >=0 ) {
                    dummy.next = new ListNode(l1.val + adder - 10);
                }else {
                    dummy.next = new ListNode(l1.val + adder);
                    adder = 0;
                }
                l1 = l1.next;
                dummy = dummy.next;
            }else {
                dummy.next = l1;
                return res.next;
            }
        }

        while (l2 != null) {
            if(adder == 1) {
                if(l2.val + adder - 10 >=0 ) {
                    dummy.next = new ListNode(l2.val + adder - 10);
                }else {
                    dummy.next = new ListNode(l2.val + adder);
                    adder = 0;
                }
                l2 = l2.next;
                dummy = dummy.next;
            }else {
                dummy.next = l2;
                return res.next;
            }
        }

        if(adder == 1) {
            dummy.next = new ListNode(1);
        }
        return res.next;
    }

    public void out(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        out(head.next);
    }

    public static void main(String[] args) {
        LC11_AddTwoNumberLinkedList addTwoNumberLinkedList = new LC11_AddTwoNumberLinkedList();
        // 1 -> 2 -> 2 -> 1 -> 5
        ListNode head = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(1);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode head2 = new ListNode(1);
//        ListNode lt2 = new ListNode(9);
//        head2.next = lt2;

        ListNode res = addTwoNumberLinkedList.addTwoNumbers(head, head2);
        addTwoNumberLinkedList.out(res);
    }
}
