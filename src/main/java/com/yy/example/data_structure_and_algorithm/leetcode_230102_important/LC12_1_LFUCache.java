package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Least Frequently Used - 最少使用 - 频次的最少使用 困难
 * <pre>
 * 实现 LFUCache 类之数据结构定义
 * </pre>
 */
class LC12_1_LFUCache {

    int capacity;

    // 存储 key value，已达到get 时时间复杂度是O(1)
    HashMap<String, Integer> kv = new HashMap();

    // 存储key freq，已达到知道每个key的访问次数
    HashMap<String, Integer> kf = new HashMap<>();

    // 每个次数对应的key，可能存在相同次数的key，所以用set，因为相同次数要删除最早加入的key，所以用带顺序的LinkedHashSet
    HashMap<Integer, LinkedHashSet<String>> fks = new HashMap<>();

    // 当容量满时，需要删除访问频次最低的key，这时需要遍历kf，那就不满足put() 方法的时间复杂度是O(1)，所以需要定义最小频次的变量
    int minFreq;

    public LC12_1_LFUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * int get(int key)- 如果键key 存在于缓存中，则获取键的值，否则返回 -1
     *
     * @param key
     * @return
     */
    public int get(int key) {
        return -1;
    }

    /**
     * void put(int key, int value)- 如果键key 已存在，则变更其值；如果键不存在，请插入键值对。
     * 当缓存达到其容量capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
     * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
     * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
    }
}