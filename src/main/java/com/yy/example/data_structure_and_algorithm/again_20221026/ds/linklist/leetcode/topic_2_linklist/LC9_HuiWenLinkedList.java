package com.yy.example.data_structure_and_algorithm.again_20221026.ds.linklist.leetcode.topic_2_linklist;

/**
 * Description: 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/fov6t/
 * </pre>
 */
public class LC9_HuiWenLinkedList {

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        // 到这里时，s 指向的是如果是偶数：s.next 指向的是一半的第一个节点；如果是奇数：s.next 指向的是一半的第一个节点
        // s 指向一半的第一个节点
        s = s.next;

        /// 反转 s 链表
        ListNode newS = reverse(s);

        // f 指向头节点
        f = head;
        // s 和 f 开始一对一比较
        while (newS != null && f != null) {
            if(newS.val != f.val) {
                return false;
            }
            newS = newS.next;
            f = f.next;
        }
        return true;
    }

    private ListNode reverse(ListNode s) {
        ListNode pre = null;
        ListNode cur = s;

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

    public void out(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        out(head.next);
    }

    public static void main(String[] args) {
        LC9_HuiWenLinkedList huiWenLinkedList = new LC9_HuiWenLinkedList();
        // 1 -> 2 -> 2 -> 1 -> 5
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        boolean isPaliedrome = huiWenLinkedList.isPalindrome(head);
        System.out.println(isPaliedrome);
    }
}
