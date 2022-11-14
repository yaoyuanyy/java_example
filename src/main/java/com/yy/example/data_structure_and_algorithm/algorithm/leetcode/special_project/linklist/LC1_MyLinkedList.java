package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.special_project.linklist;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/12/22 at 2:37 PM
 */
public class LC1_MyLinkedList {

    SingleListNode head;
//    SingleListNode tail;

    /**
     * 数据结构：单链表节点：数据项+指向下一个节点的引用
     */
    class SingleListNode {

        int value;
        SingleListNode next;

        public SingleListNode(int value, SingleListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public LC1_MyLinkedList() {
    }

    public int get(int index) {
        return 0;
    }

    public void addAtHead(int val) {
        SingleListNode tmp = head;
        if(tmp == null) {
            head = new SingleListNode(val, null);
        }else {
            head = new SingleListNode(val, tmp);
        }
    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }

    public void out(SingleListNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value + " ");
        out(node.next);
    }

    public static void main(String[] args) {
        LC1_MyLinkedList myLinkedList = new LC1_MyLinkedList();
        int index = 1;
        int param_1 = myLinkedList.get(index);
        myLinkedList.addAtHead(10);
        myLinkedList.addAtHead(11);
        myLinkedList.addAtHead(12);
        myLinkedList.out(myLinkedList.head);
//        obj.addAtTail(val);
//        obj.addAtIndex(index, val);
//        obj.deleteAtIndex(index);
    }
}

