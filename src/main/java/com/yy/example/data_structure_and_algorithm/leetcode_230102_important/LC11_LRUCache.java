package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

import java.util.HashMap;

/**
 * Least recently used - 最少使用 - 最近的最少使用
 * <pre>
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
 * 如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * [算法就像搭乐高：带你手撸 LRU 算法](https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-daeca/suan-fa-ji-8674e/)
 * https://leetcode.cn/problems/lru-cache/
 *
 * 方法一：哈希表 + 双向链表
 * </pre>
 */
class LC11_LRUCache {

    // 缓存初始化长度
    int capacity;
    // 当前数据长度
    int size;
    DLinkedNode head;
    DLinkedNode tail;

    HashMap<Integer, DLinkedNode> cache = new HashMap<>();

    /**
     * 通过key 定位到要操作的node，通过这个node 定位到它在链表中的位置，就可以操作它和它的前后继节点了，从而实现了都是O(1)的操作
     * 哈希表:（key, node）
     * 双向链表: pre <-> node <-> next
     * 哈希表：why：因为哈希表的存储结构是数组，通过数组下标可以快速定位到要找的位置；同时，key 哈希后再模上长度，就可以确定下标了，即找到位置
     *            参见：https://www.cnblogs.com/yddwinter/p/15410235.html
     * 双向链表：why：因为题目要求删除操作也是O(1)，如果是单链表，那么需要多次遍历才能找到删除节点的前继节点，这就不能是O(1)了。
     */

    /**
     * @param capacity
     */
    public LC11_LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode(-1, -1, null, null);
        tail = new DLinkedNode(-1, -1, null, null);

        head.next = tail;
        tail.pre = head;
    }

    /**
     * 思路：如果hashMap中没有这个key，返回-1;
     *      从原位置移动到头部
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        // 移动到头部
        // 从原来位置删除
        removeNode(node);
        addToHead(node);
        // 放到头部
        return node.value;
    }

    /**
     * 新增的key value，
     * 如果key 存在，覆盖原值
     * 如果key 不存在，创建新节点，放入头部
     * 如果放入后长度超过容量，同时删除尾部节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value, null, null);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
            }
        }else {
            node.value = value;
            // 移动到头部
            // 从原来位置删除
            removeNode(node);
            addToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(int key, int value, DLinkedNode pre, DLinkedNode next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

}