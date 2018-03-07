package com.yy.example.data_structure.link_list;

/**
 * Description:
 * <p>
 * <p></p>
 * <pre>
 *     反转参考：
 *     http://blog.csdn.net/beiyetengqing/article/details/7596554
 *     http://blog.csdn.net/feliciafay/article/details/6841115
 * </pre>
 * NB.
 * Created by skyler on 2017/12/23 at 下午11:05
 */
public class SingleLinkedListTest {

    Node<Integer> head;
    Node<Integer> tail;


    public void add(final Integer data) {
        final Node<Integer> node = new Node<Integer>(data, null);
//        if (head == null) {
//            head = node;
//            head.next = tail;
//            tail = node;
//        } else {
//            final Node tmp = tail;
//            tmp.next = node;
//            tail = node;
//        }

        final Node<Integer> tmp = tail;
        tail = node;
        if (tmp == null) {
            head = node;
        } else {
            tmp.next = node;
        }
    }

    /**
     * 按照data值从大到小的顺序存节点
     * <pre>
     *     如:
     *     1,3,5,2,4
     *     每次存的时候调用addBySort方法，所有的data存完后调用out方法从head到tail打印输出:
     *     5,4,3,2,1
     * </pre>
     *
     * @param data
     */
    public void addBySort(final Integer data) {
        final Node<Integer> node = new Node<Integer>(data, null);
        final Node<Integer> tmp = head;

        if (tmp == null) {
            head = node;
            tail = node;
        } else if (data >= tmp.data) {
            head = node;
            head.next = tmp;
            if (tmp.next == null) {
                tail = tmp;
            }
        } else {
            Node<Integer> front = head.next;
            Node<Integer> prev = head;
            while (front != null && front.data > data) {
                prev = front;
                front = front.next;
            }

            prev.next = node;
            node.next = front;
            if (front == null) {
                tail = node;
            }
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

    public static void main(final String[] args) {
        final SingleLinkedListTest test = new SingleLinkedListTest();
//        test.add(1);
//        test.add(3);
//        test.add(5);
//        test.add(4);
//        test.add(2);

        /**
         * addBySort方法-测试用例1-----------------
         */
        test.addBySort(1);
        test.addBySort(3);
        test.addBySort(5);
        test.addBySort(2);
        test.addBySort(4);

        /**
         * addBySort方法-测试用例2-----------------
         */
//        test.addBySort(2);
//        test.addBySort(5);
//        test.addBySort(1);
//        test.addBySort(3);
//        test.addBySort(4);

        /**
         * addBySort方法-测试用例3-----------------
         */
//        test.addBySort(5);
//        test.addBySort(1);
//        test.addBySort(2);
//        test.addBySort(3);
//        test.addBySort(4);

        //打印
        test.out(test.getHead());

        System.out.println("head.data:" + test.head.data);
        System.out.println("tail.data:" + test.tail.data);

    }

    /**
     * TODO
     * 对已有链表进行按data值(假设data是int类型)由小到大排序
     * <p>
     * <pre>
     *     Java单链表实现快速排序:
     *     http://blog.csdn.net/bug_moving/article/details/56677219
     * </pre>
     */
    public void sort() {
        final Node<Integer> cur = head;
        while (cur != null) {
            final Node<Integer> next = head.next;
            if (next == null) return;

            if (cur.data > next.data) {

            }
        }

    }

    class Node<T> {
        T data;
        Node next;

        public Node() {

        }

        public Node(final T data, final Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node<Integer> getHead() {
        return head;
    }

    public void setHead(final Node<Integer> head) {
        this.head = head;
    }

    public Node<Integer> getTail() {
        return tail;
    }

    public void setTail(final Node<Integer> tail) {
        this.tail = tail;
    }
}


