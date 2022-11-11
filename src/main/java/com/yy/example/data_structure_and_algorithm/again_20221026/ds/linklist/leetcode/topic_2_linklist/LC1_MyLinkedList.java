package com.yy.example.data_structure_and_algorithm.again_20221026.ds.linklist.leetcode.topic_2_linklist;

/**
 * Description: 设计链表
 * <pre>
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 链接：https://leetcode.cn/leetbook/read/linked-list/jy291/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC1_MyLinkedList {

    ListNode head;
    ListNode tail;

    public LC1_MyLinkedList() {

    }

    public int get(int index) {
        return 0;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public static void main(String[] args) {
        LC1_MyLinkedList linkedList = new LC1_MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        //链表变为1-> 2-> 3
        linkedList.addAtIndex(1, 2);
        //返回2
        linkedList.get(1);
        //现在链表是1-> 3
//        linkedList.deleteAtIndex(1);
        //返回3
        linkedList.get(1);
    }
}
