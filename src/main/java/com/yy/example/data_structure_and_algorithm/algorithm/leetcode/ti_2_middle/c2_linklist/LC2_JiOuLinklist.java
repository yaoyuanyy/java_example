package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_2_middle.c2_linklist;

/**
 * Description: 奇偶链表
 * <pre>
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * 示例 1:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 *
 * 示例 2:
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvdwtj/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/9/22 at 10:25 AM
 */
public class LC2_JiOuLinklist {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head;
        // 奇数
        ListNode odd = head;
        // 偶数
        ListNode even = head.next;
        ListNode evenHead = even;

        head = head.next.next;
        boolean isOdd = true;
        while (head != null) {
            if(isOdd) {
                odd.next = head;
                odd = odd.next;
            }else {
                even.next = head;
                even = even.next;
            }
            isOdd = !isOdd;
            head = head.next;
        }
        odd.next = evenHead;
        even.next = null;
        return res;
    }

    public void output(ListNode node){
        if(node == null){
            return;
        }
        System.out.println("node.value:" + node.value);
        output(node.next);
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        LC2_JiOuLinklist jiOuLinklist = new LC2_JiOuLinklist();
        ListNode res = jiOuLinklist.oddEvenList(head);
        jiOuLinklist.output(res);
    }
}
