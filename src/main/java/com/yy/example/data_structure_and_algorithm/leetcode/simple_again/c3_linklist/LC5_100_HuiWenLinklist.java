package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c3_linklist;

import java.util.Stack;

/**
 * Description: 回文链表
 * <pre>
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-03 at 14:39
 */
public class LC5_100_HuiWenLinklist {

    ListNode head;

    /**
     * 1.两个指针，快指针，慢指针：启示：指针可以挨着走，也可以跳着走
     * 2.反转后半段
     * 3.然后对比是否相等
     *
     * @param head
     * @return
     */
    public boolean isPalindrome0(ListNode head) {
        ListNode fastP = head;
        ListNode slowP = head;
        while (null != fastP && null != fastP.next) {
            fastP = fastP.next.next;
            slowP = slowP.next;
        }
        if(null != fastP) {
            slowP = slowP.next;
        }

        ListNode tmp = reverseList1(slowP);

        while (null != head && null != tmp) {
            if(head.val != tmp.val) {
                return false;
            }
            head = head.next;
            tmp = tmp.next;
        }

        return true;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (null != cur) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    /**
     * 使用栈：整个链表倒过来
     * 效率低
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode tmp = head;
        while (null != tmp) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        ListNode t2 = head;
        while (null != t2) {
            if(stack.pop().val != t2.val) {
                return false;
            }
            t2 = t2.next;
        }

        return true;
    }

    /**
     * 使用栈：优化版：半个链表倒过来就可以了
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int len = 0;
        ListNode tmp = head;

        while (null != tmp) {
            stack.push(tmp);
            len++;
            tmp = tmp.next;
        }

        len = len >> 1;

        while (len > 0) {
            if(head.val != stack.pop().val) {
                return false;
            }
            len--;
            head = head.next;
        }

        return true;
    }

    /**
     * 递归 todo
     *
     * @param head
     * @return
     */
    public boolean isPalindrome4(ListNode head) {
        return false;
    }

    public void out(ListNode node) {
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LC5_100_HuiWenLinklist huiWenLinklist = new LC5_100_HuiWenLinklist();
        ListNode ln1 = new ListNode(10);
        ListNode ln2 = new ListNode(20);
        ListNode ln3 = new ListNode(30);
        ListNode ln4 = new ListNode(20);
        ListNode ln5 = new ListNode(10);

        huiWenLinklist.head = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        boolean result = huiWenLinklist.isPalindrome0(huiWenLinklist.head);
        System.out.println(result);
    }
}
