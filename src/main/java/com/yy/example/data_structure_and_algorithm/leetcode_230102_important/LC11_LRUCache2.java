package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

import java.util.LinkedHashMap;
import java.util.Map;

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
 * 方法二：借助{@link java.util.LinkedHashMap}
 * </pre>
 */
class LC11_LRUCache2 extends LinkedHashMap<Integer, Integer> {

    int capacity;

    public LC11_LRUCache2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}