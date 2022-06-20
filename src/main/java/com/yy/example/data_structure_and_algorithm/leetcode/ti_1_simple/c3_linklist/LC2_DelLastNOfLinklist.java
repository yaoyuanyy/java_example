package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c3_linklist;

/**
 * Description: 删除链表的倒数第N个节点
 * <pre>
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
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
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-02 at 07:22
 */
public class LC2_DelLastNOfLinklist {

    ListNode head;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fNode = head;
        ListNode sNode = head;

        if(null == head) {
            return null;
        }


        while (n != 0) {
            fNode = fNode.next;
            n--;
        }

        if(null == fNode) {
            return head.next;
        }

        while (null != fNode.next) {
            fNode = fNode.next;
            sNode = sNode.next;
        }

        System.out.println(sNode.val);

        sNode.next = sNode.next.next;

        return head;
    }

    public void out() {
        ListNode node = head;
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static void main(String[] args) {
        LC2_DelLastNOfLinklist delLastNOfLinklist = new LC2_DelLastNOfLinklist();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        delLastNOfLinklist.head = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        delLastNOfLinklist.removeNthFromEnd(delLastNOfLinklist.head, 2);

        //delLastNOfLinklist.out();
    }
}
