package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

/**
 * Least Frequently Used - 最少使用 - 频次的最少使用 困难
 * <pre>
 * 实现 LFUCache 类之算法描述
 *
 * LFUCache(int capacity) - 用数据结构的容量capacity 初始化对象
 * int get(int key)- 如果键key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value)- 如果键key 已存在，则变更其值；如果键不存在，请插入键值对。
 * 当缓存达到其容量capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * [算法就像搭乐高：带你手撸 LFU 算法](https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-daeca/suan-fa-ji-fb527/)
 * https://mp.weixin.qq.com/s/oXv03m1J8TwtHwMJEZ1ApQ
 * https://leetcode.cn/problems/lfu-cache/
 * </pre>
 */
class LC12_0_LFUCache {

    int capacity;

    public LC12_0_LFUCache(int capacity) {
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