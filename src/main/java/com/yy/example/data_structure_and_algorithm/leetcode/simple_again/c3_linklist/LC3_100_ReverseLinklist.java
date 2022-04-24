package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c3_linklist;

/**
 * Description: 反转链表 重点
 * <pre>
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  

 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 *
 * refer to https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
 *          https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-02 at 20:18
 */
public class LC3_100_ReverseLinklist {

    ListNode head;

    /**
     * 方法一：迭代
     *
     * @param head
     * @return
     */
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
     * 双链表求解
     * 双链表求解是把原链表的结点一个个摘掉，每次摘掉的链表都让他成为新的链表的头结点，然后更新新链表。下面以链表1→2→3→4为例画个图来看下。
     * https://pic.leetcode-cn.com/740ff8077ab684e38570d6f4240451834664cfc91b42ff2c5bca3c2d7ed73f31-image.png
     * 他每次访问的原链表节点都会成为新链表的头结点，最后再来看下代码
     * @param head
     * @return
     */
    public ListNode reverseList1_1(ListNode head) {
        return null;
    }

    /**
     * 方法二：递归
     *
     * @param head todo
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return null;
    }

    /**
     * 方法三：栈 todo
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        return null;
    }

    /**
     * 方法四：技巧 todo
     * 作者：触不可及
     * <pre>
     *     public ListNode reverseList(ListNode head) {
     *         ListNode ans = null;
     *         for (ListNode x = head; x != null; x = x.next) {
     *             ans = new ListNode(x.val,ans);
     *         }
     *         return ans;
     *     }
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        return null;
    }

    public void out(ListNode node) {
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LC3_100_ReverseLinklist reverseLinklist = new LC3_100_ReverseLinklist();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        reverseLinklist.head = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ListNode result = reverseLinklist.reverseList1(reverseLinklist.head);

        reverseLinklist.out(result);
    }
}
