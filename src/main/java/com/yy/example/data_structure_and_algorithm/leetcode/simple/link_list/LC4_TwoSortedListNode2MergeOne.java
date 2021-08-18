package com.yy.example.data_structure_and_algorithm.leetcode.simple.link_list;

/**
 * Description: 合并两个有序链表
 * <pre>
 *  将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 *
 *  方法一：递归
 *  方法二：迭代
 *  https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-07-15 at 21:26
 */
public class LC4_TwoSortedListNode2MergeOne {

    public static void main(String[] args) {
        // 1 --> 8
        ListNode<Integer> l1 = new ListNode<>(1);
        l1.next = new ListNode<>(8);
        // outListNode(l1);

        // 1 --> 3 --> 4
        ListNode<Integer> l2 = new ListNode<>(1);
        l2.next = new ListNode<>(3);
        l2.next.next = new ListNode<>(4);
        // outListNode(l2);

//        ListNode<Integer> lNew = merge2NewOne(l1, l2);
        ListNode<Integer> lNew = merge2NewOne2(l1, l2);

        outListNode(lNew);
    }

    /**
     * 方法二：迭代
     * 思路
     * 我们可以用迭代的方法来实现上述算法。当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
     * 当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
     *
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
     *
     * @param node1
     * @param node2
     * @return
     */
    private static ListNode<Integer> merge2NewOne2(ListNode<Integer> node1, ListNode<Integer> node2) {
        ListNode<Integer> newNode = new ListNode<>();
        ListNode<Integer> result = newNode;

        while (node1 != null && node2 != null){
            if(node1.data < node2.data){
                newNode.next = node1;
                node1 = node1.next;
            }else {
                newNode.next = node2;
                node2 = node2.next;
            }
            newNode = newNode.next;
        }

        newNode.next = (node1 == null) ? node2 : node1 ;

        return result;
    }

    private static ListNode<Integer> merge2NewOne(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode<Integer> result = new ListNode<>();
        ListNode<Integer> lNew = result;

        ListNode<Integer> l1Tmp = l1;
        ListNode<Integer> l2Tmp = l2;
        while (l1Tmp != null && l2Tmp != null){
            lNew.data = (l1Tmp.data < l2Tmp.data) ? l1Tmp.data : l2Tmp.data;
            lNew.next = new ListNode<>();

            if(l1Tmp.data < l2Tmp.data) {
                l1Tmp = l1Tmp.next;
            }else {
                l2Tmp = l2Tmp.next;
            }

            if(l1Tmp == null) {
                lNew.next = l2Tmp;
            }

            if(l2Tmp == null) {
                lNew.next = l1Tmp;
            }

            lNew = lNew.next;
        }

        return result;
    }

    private static void outListNode(ListNode<Integer> node) {
        int i = 0;
        while (node != null) {
            System.out.println("index:" + i + " data:" + node.data);
            node = node.next;
            i ++;
        }
    }

    /**
     * Description:
     * <pre>
     *
     * </pre>
     * NB.
     *
     * @author skyler_11@163.com
     * Created by on 2021-07-16 at 10:44
     */
    public static class ListNode<T>{
        T data;
        ListNode next;

        public ListNode() {
        }

        public ListNode(T data) {
            this.data = data;
        }
    }
}
