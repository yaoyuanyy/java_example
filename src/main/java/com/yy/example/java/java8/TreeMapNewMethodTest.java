package com.yy.example.java.java8;

import java.util.TreeMap;

/**
 * Description: test sortedMap method
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-06 at 16:10
 */
public class TreeMapNewMethodTest {

    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(30, "vv8");
        treeMap.put(20, "vv5");
        treeMap.put(50, "vv3");
        treeMap.put(40, "vv4");
        treeMap.put(60, "vv2");
        treeMap.put(10, "vv6");
        treeMap.put(80, "vv1");

        System.out.println("treeMap.firstEntry():" + treeMap.firstEntry());

        // 大于等于给定key的最小的那个
        System.out.println("treeMap.ceilingEntry(30):" + treeMap.ceilingEntry(30));

        // 小于等于给定key的最大的那个
        System.out.println("treeMap.floorEntry(30):" + treeMap.floorEntry(30));

        // 小于给定key的最大的那个
        System.out.println("treeMap.lowerEntry(30):" + treeMap.lowerEntry(30));

        // 大于给定key的最小的那个
        System.out.println("treeMap.higherEntry(30):" + treeMap.higherEntry(30));

        // 小于给定key的Entry集合
        System.out.println("treeMap.headMap(30):" + treeMap.headMap(30));

        // 小于等于给定key的Entry集合
        System.out.println("treeMap.headMap(30, true):" + treeMap.headMap(30, true));

        // 大于等于给定key的Entry集合
        System.out.println("treeMap.tailMap(30):" + treeMap.tailMap(30));

        // 大于给定key的Entry集合
        System.out.println("treeMap.tailMap(30, false):" + treeMap.tailMap(30, false));

        // --> 有则更新value，没有则创建
        System.out.println("treeMap.compute:" + treeMap.compute(25, (k, v) -> v + "-test"));

        // 如果不存在key的Entry，创建这个key的Entry，并赋value值 --> 如果不存在，则创建
        System.out.println("treeMap.computeIfAbsent:" + treeMap.computeIfAbsent(35, k -> k + "-test"));

        // 如果存在key的Entry，赋新value值 --> 如果存在则更新
        System.out.println("treeMap.computeIfPresent:" + treeMap.computeIfPresent(45, (k, v) -> v + "vv-test"));

        // 返回并删除第一个Entry
        System.out.println("treeMap.pollFirstEntry():" + treeMap.pollFirstEntry());

        // 有顺序的key的set集合
        System.out.println(treeMap.navigableKeySet());

    }
}
