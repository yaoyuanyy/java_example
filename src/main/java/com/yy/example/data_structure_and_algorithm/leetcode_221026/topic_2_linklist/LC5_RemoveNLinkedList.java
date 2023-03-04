package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_2_linklist;

/**
 * Description: 删除链表的倒数第N个节点
 * <pre>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/jf1cc/
 * </pre>
 */
public class LC5_RemoveNLinkedList {

    /**
     * 参考：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        // 第一个指针先走 n 个节点
        for (int i = 0; i < n; i++) {
            firstPointer = firstPointer.next;
        }
        // 如果为null，删除的是头节点
        if(firstPointer == null) {
            return head.next;
        }
        while (firstPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        // 到这里secondPointer节点是要删除节点的前继节点
        secondPointer.next = secondPointer.next.next;
        return head;
    }

    /**
     * 如方法一所说，通过快慢指针完成此题是最好的。但在方法一中的if判断有些不太好理解。
     * 这里可以从另一个小角度让事情更顺畅一些
     *
     * 我们举例分析下
     * A = 1 -> 2 -> 3 -> 4 -> 5 -> null
     * 假设要删除倒数第2个节点，即 n = 2, 我们定义两个指针，f 指针指向 A 的第一个节点；s 指针指向 A 的第一个节点；
     * 具体步骤如下：1: 先让 f 走 n=2 步，f 指向 3；
     *             2: 此时同时移动 f，s 指针，直到 f 指针走到 A 的末尾，此时 f 指向了 null，s 指向了 4，即 s 正好指向了要删除的节点。
     *             由于单链表是单向的，不容易拿到一个节点的前继节点，而删除一个节点时，使用前继节点最方便，所以，我们让 s 指针开始时指向头节点的前继几点
     *             即，相当于左移了一位，这样当 f 到末尾的时候，s 指向的正好是要删除节点的前继节点
     *             3: 为此，我们定义一个虚节点指向 A 的头节点，让 s 指针指向它。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        // 需要有个指针一直指向链表头节点，因为其他两个指针移动到了末尾
        ListNode tmpHead = s;
        ListNode f = head;
        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return tmpHead.next;
    }

    public static void main(String[] args) {
        LC5_RemoveNLinkedList removeNLinkedList = new LC5_RemoveNLinkedList();
        // head n2   n3   n4
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode headA = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        headA.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        int n = 1;
        System.out.println(removeNLinkedList.removeNthFromEnd(headA, n));
    }
}
