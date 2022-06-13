package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c3_linklist;

/**
 * Description: 删除链表中的节点
 * <pre>
 *
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 *
 * 题目数据保证需要删除的节点 不是末尾节点 。
 *
 * from：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
 *
 * refer to https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/tu-jie-shan-chu-lian-biao-zhong-de-jie-dian-python/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-01 at 07:56
 */
public class LC1_DelNodeOfLinkList {

    ListNode head;

   public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void out() {
        ListNode node = head;
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LC1_DelNodeOfLinkList delNodeOfLinkList = new LC1_DelNodeOfLinkList();
        ListNode ln1 = new ListNode(4);
        ListNode ln2 = new ListNode(5);
        ListNode ln3 = new ListNode(1);
        ListNode ln4 = new ListNode(9);

        delNodeOfLinkList.head = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        delNodeOfLinkList.deleteNode(ln2);

        delNodeOfLinkList.out();
    }
}
