package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_2_linklist;

/**
 * Description: 奇偶链表
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * 示例 1:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * 示例 2:
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/fe0kj/
 * </pre>
 */
public class LC8_OddEvenLinkedList {

    /**
     * 官方的方法更好：
     * https://leetcode.cn/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode-solution/
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        boolean isOdd = true;
        ListNode odd = null;
        ListNode even = null;
        ListNode oddStart = null;
        ListNode evenStart = null;
        while (head != null) {
            if(isOdd) {
                if(odd == null) {
                    odd = head;
                    oddStart = odd;
                }else {
                    odd.next = head;
                    odd = odd.next;
                }
            }else {
                if(even == null) {
                    even = head;
                    evenStart = even;
                }else {
                    even.next = head;
                    even = even.next;
                }
            }
            isOdd = !isOdd;
            head = head.next;
        }

        even.next = null;
        // 到这的时候，odd 是最后一个奇数，even 是最后一个偶数
        // 偶数的链表连接到奇数链表的后面即可
        odd.next = evenStart;

        return oddStart;
    }

    public void out(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        out(head.next);
    }

    public static void main(String[] args) {
        LC8_OddEvenLinkedList oddEvenLinkedList = new LC8_OddEvenLinkedList();
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        n5.next = n6;

        ListNode node = oddEvenLinkedList.oddEvenList(head);
        oddEvenLinkedList.out(node);
    }
}
