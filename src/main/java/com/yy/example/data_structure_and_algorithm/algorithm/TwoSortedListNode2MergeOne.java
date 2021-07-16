package com.yy.example.data_structure_and_algorithm.algorithm;

/**
 * Description:
 * <pre>
 *  描述:
 *  将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-07-15 at 21:26
 */
public class TwoSortedListNode2MergeOne {

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

        ListNode<Integer> lNew = merge2NewOne(l1, l2);
        outListNode(lNew);
    }

    private static ListNode<Integer> merge2NewOne(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode<Integer> result = new ListNode<>();
        ListNode<Integer> lNew = new ListNode<>();

        result = lNew;

        ListNode<Integer> l1Tmp = l1;
        ListNode<Integer> l2Tmp = l2;
        while (l1Tmp != null && l2Tmp != null){
            int l1Value = l1Tmp.data;
            int l2Value = l2Tmp.data;
            lNew.data = (l1Value < l2Value) ? l1Value : l2Value;
            lNew.next = new ListNode<>();

            if(l1Value < l2Value) {
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
}
