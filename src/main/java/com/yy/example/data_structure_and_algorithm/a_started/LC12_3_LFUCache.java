package com.yy.example.data_structure_and_algorithm.a_started;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Least Frequently Used - 最少使用 - 频次的最少使用 困难
 * <pre>
 * 实现 LFUCache 类之核心逻辑
 * </pre>
 */
class LC12_3_LFUCache {

    int capacity;

    // 存储 key value，已达到get 时时间复杂度是O(1)
    HashMap<Integer, Integer> k2v = new HashMap();

    // 存储key freq，已达到知道每个key的访问次数，也达到O(1)复杂度的对key加减操作
    HashMap<Integer, Integer> k2f = new HashMap<>();

    // 每个次数对应的key，可能存在相同次数的key，所以用set，因为相同次数要删除最早加入的key，所以用带顺序的LinkedHashSet
    HashMap<Integer, LinkedHashSet<Integer>> f2ks = new HashMap<>();

    // 当容量满时，需要删除访问频次最低的key，这时需要遍历kf，那就不满足put() 方法的时间复杂度是O(1)，所以需要定义最小频次的变量
    int minFreq;


    public LC12_3_LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
    }

    /**
     * int get(int key)- 如果键key 存在于缓存中，则获取键的值，否则返回 -1
     *
     * @param key
     * @return
     */
    public int get(int key) {
        Integer value = k2v.get(key);
        if(value == null) {
            return -1;
        }
        // 更新key的访问次数
        increaseFreq(key);
        return value;
    }

    /**
     * void put(int key, int value)- 如果键key 已存在，则变更其值；如果键不存在，请插入键值对。
     * 当缓存达到其容量capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
     * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
     * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
     */
    public void put(int key, int value) {
        if(k2v.containsKey(key)) {
            // 更新新值
            k2v.put(key,value);
            increaseFreq(key);
            return;
        }
        if(capacity <= k2v.size()) {
            // 删除访问次数最小的key
            removeMinFreqKey();
        }

        k2v.put(key, value);
        k2f.put(key, 1);
        f2ks.putIfAbsent(1, new LinkedHashSet<>());
        f2ks.get(1).add(key);
        // 新的key 存储进来，肯定是访问次数最低的key 之一，所以minFrq 肯定为1
        this.minFreq = 1;
    }

    /**
     * 核心逻辑
     */
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = f2ks.get(minFreq);
        // 淘汰集合的第一个元素
        Integer delKey = keys.iterator().next();
        keys.remove(delKey);
        // 删除后可能为空
        if(keys.isEmpty()) {
            f2ks.remove(minFreq);
        }

        k2v.remove(delKey);
        k2f.remove(delKey);
    }

    private void increaseFreq(int key) {
        int freq = k2f.get(key);
        // 更新key 的访问次数
        k2f.put(key, freq + 1);

        // 将key 从freq 对应的列表中删除
        f2ks.get(freq).remove(key);

        // 将key 加入 freq + 1 对应的列表中
        f2ks.putIfAbsent(freq + 1, new LinkedHashSet<>());
        f2ks.get(freq + 1).add(key);

        // freq 的集合减少了 key，所以需要更新freq 的集合，减少后可能为空
        if(f2ks.get(freq).isEmpty()) {
            f2ks.remove(freq);
            // 这里想不通它的逻辑 ＊
            if(freq == minFreq) {
                this.minFreq++;
            }
        }
    }
}