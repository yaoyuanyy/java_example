package com.yy.example.data_structure_and_algorithm.leetcode.simple.link_list;

/**
 * Description: 反转链表
 * <pre>
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 *
 * 链表相关的其他题：https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-10 at 19:27
 */
public class LC3_ReverseLinkList {
    Node head;

    public static void main(String[] args) {
        LC3_ReverseLinkList obj = new LC3_ReverseLinkList();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);

        System.out.println("初始化后的链表如下：");
        obj.out(obj.head);

        Node newHead = obj.reverseWithIterate(obj.head);
        System.out.println("反转后的链表如下：");
        obj.out(newHead);

    }

    /**
     * 方法一：迭代
     * 假设链表为 1→2→3→∅，我们想要把它改成 ∅←1←2←3。
     * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
     * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
     * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     *
     * @param head
     * @return
     */
    public Node reverseWithIterate(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     *
     * @param head
     * @return
     */
    public Node reverseWithNewMem(Node head) {
        Node tt = null;
        for (Node cur = head; cur != null; cur = cur.next) {
            tt = new Node<>(cur.data, tt);
        }

        return tt;
    }

    public void add(final Integer data) {
        final Node<Integer> node = new Node<>(data, null);
        if (head == null) {
            head = node;
        } else {
            Node<Integer> tmp = head;
            Node<Integer> pre = null;
            while (tmp != null) {
                pre = tmp;
                tmp = tmp.next;
            }
            // 最后一个节点
            pre.next = node;
        }
    }

    /**
     * 从head到tail打印输出链表
     *
     * @param node
     */
    public void out(Node<Integer> node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    class Node<T> {
        T data;
        Node next;

        public Node() {}

        public Node(final T data, final Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

