package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_2_linklist;

/**
 * Description: 移除链表元素
 * <pre>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/f9izv/
 * </pre>
 */
public class LC7_RemoveElementsLinkedList {

    /**
     * 最简单的方法：生成新对象的方式
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        if(head == null) {
           return head;
        }
        for (; head != null; head = head.next) {
            if(head.val != val) {
                ListNode listNode = new ListNode(head.val);
                dummy.next = listNode;
                dummy = dummy.next;
            }
        }
        return tmp.next;
    }

    /**
     * 迭代
     *
     * https://leetcode.cn/problems/remove-linked-list-elements/solution/yi-chu-lian-biao-yuan-su-by-leetcode-sol-654m/
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode res = dummy;
        // 条件为啥是dummy.next != null 而不是dummy != null，因为单链表删除节点是，通过它的前继节点最容易处理
        // 但是这样就错过了链表的头节点，所以才有了要定义一个虚节点，头节点作为它的next 节点。从而所有节点步调一致
        // dummy 节点指针在 while 循环过程中是不断后移的，所以在退出循环后 dummy 是最后一个节点。所以，为了返回头节点，
        // 定义 res，始终保持对头节点的指向
        while (dummy.next != null) {
            if(dummy.next.val == val) {
                dummy.next = dummy.next.next;
            }else {
                dummy = dummy.next;
            }
        }
        return res.next;
    }

    /**
     * 递归
     * ＊
     * https://leetcode.cn/problems/remove-linked-list-elements/solution/yi-chu-lian-biao-yuan-su-by-leetcode-sol-654m/
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        // 每次出栈，意味着当前指针往左平移一步，举例：1,2,6 val=6
        head.next = removeElements3(head.next, val);
        // 方法递归到最后节点，head.next=null，head=6 等于val，所以null是返回值
        // 一旦出栈，指针左移，此时 head=2，head.next指向的是返回值，即2->null，即6被删除了
        return head.val == val ? head.next : head;
    }

    public void out(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        out(head.next);
    }

    public static void main(String[] args) {
        LC7_RemoveElementsLinkedList removeElementsLinkedList = new LC7_RemoveElementsLinkedList();
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(3);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode node = removeElementsLinkedList.removeElements3(head, 3);
        removeElementsLinkedList.out(node);
    }
}
