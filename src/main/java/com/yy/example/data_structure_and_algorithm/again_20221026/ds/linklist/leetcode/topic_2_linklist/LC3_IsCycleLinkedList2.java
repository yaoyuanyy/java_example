package com.yy.example.data_structure_and_algorithm.again_20221026.ds.linklist.leetcode.topic_2_linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 环形链表 II
 * <pre>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/jjhf6/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC3_IsCycleLinkedList2 {

    /**
     * 利用哈希set去重特性
     *
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> cap = new HashSet<>();
        while (head != null) {
            if(!cap.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 好题 ＊
     * 这道题目，不仅考察对链表的操作，而且还需要一些数学运算。
     * 主要考察两知识点：
     *    判断链表是否环
     *    如果有环，如何找到这个环的入口
     *
     * https://leetcode.cn/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
     * 数学推倒很好
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        // 定义两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null) {
            if(fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LC3_IsCycleLinkedList2 cycleLinkedList = new LC3_IsCycleLinkedList2();
        // head n2   n3   n4
        // 1 -> 2 -> 3 -> 4
        //    ^---------v
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(cycleLinkedList.detectCycle2(head).val);
    }


}
