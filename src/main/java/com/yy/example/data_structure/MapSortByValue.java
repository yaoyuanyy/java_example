package com.yy.example.data_structure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/17 at 下午10:54
 */
public class MapSortByValue {

    public static void main(final String[] args) {
        // 默认情况，TreeMap按key升序排序
        final Map<String, Integer> map = new HashMap<>();
        map.put("acb1", 5);
        map.put("bac1", 3);
        map.put("bca1", 20);
        map.put("cab1", 80);
        map.put("cba1", 1);
        map.put("abc1", 10);
        map.put("abc2", 12);

        //method1(map);
        //method2(map);
        //method3(map);

    }

    /**
     * 使用java8特性
     *
     * @param map
     */
    public static void method1(final Map<String, Integer> map) {
        //java8
        final LinkedHashMap linkedHashMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(linkedHashMap);
    }

    /**
     * 使用SortedSet + 重写Comparator方法
     *
     * @param map
     */
    public static void method2(final Map map) {

        System.out.println(entriesSortedByValues(map));

    }

    private static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(final Map<K, V> map) {
        final SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>(new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(final Map.Entry<K, V> e1, final Map.Entry<K, V> e2) {
                final int res = e2.getValue().compareTo(e1.getValue());
                System.out.println("res:" + res);
                return res != 0 ? res : 1;
            }
        }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    /**
     * 使用Collections.sort(list, valueComparator); + 重写Comparator方法
     *
     * @param map
     */
    public static void method3(final Map<String, Integer> map) {
        final List list = new ArrayList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {

                return o2.getValue() - o1.getValue();
            }
        });

        list.forEach(System.out::println);
    }
}
