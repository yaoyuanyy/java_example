package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_2_linklist;

import java.util.Stack;

/**
 * Description: 反转链表 ＊＊
 * <pre>
 * 反转一个单链表。
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。这个问题是你在面试中可能遇到的许多链表问题的基础
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/f58sg/
 * </pre>
 */
public class LC6_ReverseLinkedList {

    /**
     * 这个经典的题目有很多的解法
     * 方法一：迭代，逻辑：一次反转每个节点最后形成反转链表实现
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            /// 整体：将pre -> cur -> next 转为 pre <- cur <- next，pre 为辅助节点
            // 前两行逻辑：cur指向next (cur -> next) 转为 cur 指向 pre (pre <- cur)
            ListNode next = cur.next;
            cur.next = pre;
            // 后两行逻辑：向右平移 pre，cur 指针
            pre = cur;
            cur = next;
        }
        // 此时，cur = null，所以，pre是最后一个节点，此时它已成为链表的头节点
        return pre;
    }

    /**
     * 方法二：递归，逻辑：每创建一个节点，将上一个新创建的节点作为它的后继节点
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * 没看懂，好好琢磨 ＊＊
     *
     * 心得：通过这个递归，我突然看到了递归的一个技巧(事实)：要想直接到底，递归方法放在方法开头；同时方法返回值也是最后的那个元素
     *
     * 对于递归算法，最重要的就是明确递归函数的定义。具体来说，我们的 reverse 函数定义是这样的：
     * 递归技巧：https://labuladong.github.io/algo/2/19/19/
     *
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     * https://leetcode.cn/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/ 参考 NoColor96 的解释
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // newHead 是通过递归直接到最后的节点，然后又是返回值，所以，随着递归的不断出栈，newHead 一直是最后的节点
        ListNode newHead = reverseList2(head.next);
        // 4 <-> 5
        head.next.next = head;
        // 4 <- 5
        head.next = null;
        return newHead;
    }

    /**
     * 方法三：栈，逻辑：原链表入栈，出栈时连接成新链表
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * https://leetcode.cn/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/ 参考 风在哪
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if(head == null) return head;
        Stack<ListNode> stack = new Stack<>();
        while (head.next != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode tmp = head;
        while (!stack.empty()) {
            head.next = stack.pop();
            head = head.next;
        }
        // 注意这句，此时 head是最后一个元素，因为这个元苏在原链表是头节点，它链着整个链表呢，所以要把它的 next 设置为null，以斩断其链
        head.next = null;
        return tmp;
    }

    /**
     * 方法四：创建新的链表，逻辑：每创建一个节点，将上一个新创建的节点作为它的后继节点
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        ListNode tmp = new ListNode(head.val);

        while (head.next != null) {
            ListNode newNode = new ListNode(head.next.val, tmp);
            tmp = newNode;
            head = head.next;
        }

        return tmp;
    }

    /**
     * 一个偏却牛的方法
     * https://leetcode.cn/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/ 参考 触不可及
     * @param head
     * @return
     */
    public ListNode reverseList5(ListNode head) {
        ListNode dummy = null;
        for (; head !=null; head = head.next) {
            ListNode listNode = new ListNode(head.val, dummy);
            dummy = listNode;
        }
        return dummy;
    }

    public void out(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        out(head.next);
    }

    public static void main(String[] args) {
        LC6_ReverseLinkedList reverseLinkedList = new LC6_ReverseLinkedList();
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        //        reverseLinkedList.out(head);
        ListNode node = reverseLinkedList.reverseList2(head);
        reverseLinkedList.out(node);
    }
}
