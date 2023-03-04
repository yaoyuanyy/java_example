package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_2_linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 环形链表
 * <pre>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/jbex5/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_IsCycleLinkedList {

    /**
     * 方法一：快慢指针
     * @param head
     * @return
     */
    public boolean isCycle(ListNode head) {
        // 定义两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用哈希set：hashSet不能存在重复元素，所以，无法插入重复元素，利用这个特性判断是否是环形链表
     *
     * @param head
     * @return
     */
    public boolean isCycle2(ListNode head) {
        Set<ListNode> cap = new HashSet<>();
        while (head != null) {
            if(!cap.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LC2_IsCycleLinkedList cycleLinkedList = new LC2_IsCycleLinkedList();
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

        System.out.println(cycleLinkedList.isCycle2(head));
    }


}
