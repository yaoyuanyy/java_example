package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c3_linklist;

/**
 * Description: 环形链表
 * <pre>
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-06 at 07:41
 */
public class LC6_HuanXingLinklist {

    public boolean hasCycle(ListNode head) {

        return false;
    }

    public void out(ListNode node) {
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LC6_HuanXingLinklist huiWenLinklist = new LC6_HuanXingLinklist();
        ListNode ln1 = new ListNode(10);
        ListNode ln2 = new ListNode(20);
        ListNode ln3 = new ListNode(30);
        ListNode ln4 = new ListNode(20);
        ListNode ln5 = new ListNode(10);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        boolean result = huiWenLinklist.hasCycle(ln1);
        System.out.println(result);
    }
}
