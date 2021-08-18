package com.yy.example.data_structure_and_algorithm.leetcode.simple.link_list;

/**
 * Description: 回文链表
 * <pre>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *  
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-18 at 08:56
 */
public class LC5_HuiwenLinkList {

    ListNode<Integer> head;

    public static void main(String[] args) {
        LC5_HuiwenLinkList obj = new LC5_HuiwenLinkList();
        // 1 --> 3 --> 4
        ListNode<Integer> l2 = new ListNode<>(1);
        obj.head = l2;
        l2.next = new ListNode<>(3);
        l2.next.next = new ListNode<>(4);
        l2.next.next.next = new ListNode<>(9);
        l2.next.next.next.next = new ListNode<>(100);

        method1(obj.head);
    }

    /**
     * 方法一：将值复制到数组中后用双指针法
     */
    private static void method1(ListNode<Integer> head) {

    }

    /**
     * 方法二：递归法 不会
     */
    private static void method2(ListNode<Integer> head) {

    }

    /**
     * 方法三：双指针法
     */
    private static void method3(ListNode<Integer> head) {

    }

    private void outListNode(ListNode<Integer> node) {
        int i = 0;
        while (node != null) {
            System.out.println("index:" + i + " data:" + node.data);
            node = node.next;
            i ++;
        }
    }

    public static class ListNode<T>{
        T data;
        ListNode<T> next;

        public ListNode() {
        }

        public ListNode(T data) {
            this.data = data;
        }
    }
}
