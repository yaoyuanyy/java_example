package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_2_linklist;

/**
 * Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例 1：
 * <img src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg"></img>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/fnzd1/
 * </pre>
 */
public class LC10_MergeOrderdLinkedList {

    /**
     * 定义虚节点 + 迭代
     * 从头向尾比较，小的元素链接到总链表上，同时向右移动一个节点
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            }else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if(list1 == null) {
            dummy.next = list2;
        }
        if(list2 == null) {
            dummy.next = list1;
        }
        return res.next;
    }

    /**
     * 递归
     * 从尾向头比较，
     * 递归的题好好琢磨 ＊
     *
     * 递归代码的精髓在于调用自己去解决规模更小的子问题，直到到达结束条件；
     * 递归代码最重要的两个特征：结束条件和自我调用。自我调用是在解决子问题，而结束条件定义了最简子问题的答案。
     * 递归的技巧：https://labuladong.github.io/algo/2/19/19/
     *
     * //(1,1):代表第一次进入递归函数，并且从第一个口进入，并且记录进入前链表的状态
     * merge(1,1): 1->4->5->null, 1->2->3->6->null
     *     merge(2,2): 4->5->null, 1->2->3->6->null
     *     	merge(3,2): 4->5->null, 2->3->6->null
     *     		merge(4,2): 4->5->null, 3->6->null
     *     			merge(5,1): 4->5->null, 6->null
     *     				merge(6,1): 5->null, 6->null
     *     					merge(7): null, 6->null
     *     					return l2
     *     				l1.next --- 5->6->null, return l1
     *     			l1.next --- 4->5->6->null, return l1
     *     		l2.next --- 3->4->5->6->null, return l2
     *     	l2.next --- 2->3->4->5->6->null, return l2
     *     l2.next --- 1->2->3->4->5->6->null, return l2
     * l1.next --- 1->1->2->3->4->5->6->null, return l1
     *
     * https://leetcode.cn/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/ 奶嘴超人丶
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

    public void out(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        out(head.next);
    }

    public static void main(String[] args) {
        LC10_MergeOrderdLinkedList mergeOrderdLinkedList = new LC10_MergeOrderdLinkedList();
        // 1 -> 2 -> 2 -> 1 -> 5
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        head.next = n2;
        n2.next = n3;

        ListNode head2 = new ListNode(8);
//        ListNode lt2 = new ListNode(3);
//        ListNode lt3 = new ListNode(4);
//        head2.next = lt2;
//        lt2.next = lt3;

        ListNode res = mergeOrderdLinkedList.mergeTwoLists2(head, head2);
        mergeOrderdLinkedList.out(res);
    }
}
