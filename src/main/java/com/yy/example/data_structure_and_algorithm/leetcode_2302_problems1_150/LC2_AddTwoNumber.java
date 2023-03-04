package com.yy.example.data_structure_and_algorithm.leetcode_2302_problems1_150;

/**
 * Description: 2. 两数相加
 * <pre>
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * ＊＊＊＊＊
 * 链表题小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点 head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 *
 * 链接：
 * https://leetcode.cn/problems/add-two-numbers
 * https://leetcode.cn/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_AddTwoNumber {

    /**
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            int number = sum % 10;
            cur.next = new ListNode(number);
            cur = cur.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public void out(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        out(head.next);
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 2 -> 1 -> 5
        ListNode head = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        head.next = n2;
        n2.next = n3;

        ListNode head2 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n33 = new ListNode(4);
        head2.next = n22;
        n22.next = n33;

        LC2_AddTwoNumber addTwoNumber = new LC2_AddTwoNumber();
        ListNode res = addTwoNumber.addTwoNumbers(head, head2);
        addTwoNumber.out(res);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


