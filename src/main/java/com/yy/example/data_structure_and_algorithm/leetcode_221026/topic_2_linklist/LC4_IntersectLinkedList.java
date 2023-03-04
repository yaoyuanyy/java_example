package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_2_linklist;

import java.util.HashSet;

/**
 * Description: 相交链表
 * <pre>
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/jjbj2/
 * </pre>
 *
 * 小结：链表问题方法论：通过数学的方式，推倒
 */
public class LC4_IntersectLinkedList {

    /**
     * 利用哈希set去重特性找到公共相交的节点
     * 时间复杂度为O(n)
     * 空间复杂度为O(n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if(!set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    /**
     * 好题＊
     * 通过数学推理
     * 官方：讲的逻辑比较清晰
     * https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
     *
     * 更巧妙的解释：
     * 假设c为公共部分，若相交，链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。若不相交，a+b = b+a 。因此相遇处是NULL
     * https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/ @TRQYC
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     *
     * 艺术讲解：
     * 白荷花主题豪华大床房-颜值超高的气质美女被饿狼男友一天之内干了三次
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    public static void main(String[] args) {
        LC4_IntersectLinkedList cycleLinkedList = new LC4_IntersectLinkedList();
        // head n2   n3   n4
        // 1 -> 9 -> 2 -> 4
        //      3 -> 2 -> 4
        ListNode headA = new ListNode(1);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        headA.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode headB = new ListNode(3);
        headB.next = n3;
        n3.next = n4;

        System.out.println(cycleLinkedList.getIntersectionNode(headA, headB));
    }


}
