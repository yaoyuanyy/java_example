package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c3_linklist;

/**
 * Description: 合并两个有序链表
 * <pre>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-03 at 10:03
 */
public class LC4_MergeLinklist {

    ListNode head;

    /**
     * 一般解法
     * @param n1
     * @param n2
     * @return
     */
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        if(null == n1) {
            return n2;
        }
        if(null == n2) {
            return n1;
        }

        ListNode dummy = new ListNode();
        ListNode tmp = dummy;

        while (null != n1 && null != n2) {
            if(n1.val <= n2.val) {
                tmp.next = n1;
                n1 = n1.next;
            }else {
                tmp.next = n2;
                n2 = n2.next;
            }
            tmp = tmp.next;
        }

        tmp.next = n1 == null ? n2 : n1;

        return dummy.next;
    }

    /**
     * 递归 todo
     *
     * @param n1
     * @param n2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode n1, ListNode n2) {
        return null;
    }

    public void out(ListNode node) {
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LC4_MergeLinklist mergeLinklist = new LC4_MergeLinklist();
        ListNode ln1 = new ListNode(10);
        ListNode ln2 = new ListNode(20);
        ListNode ln3 = new ListNode(30);
        ListNode ln4 = new ListNode(40);
        ListNode ln5 = new ListNode(50);
        mergeLinklist.head = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(24);
        ListNode n3 = new ListNode(55);
        n1.next = n2;
        n2.next = n3;
        ListNode result = mergeLinklist.mergeTwoLists(ln1, n1);

        mergeLinklist.out(result);
    }
}
