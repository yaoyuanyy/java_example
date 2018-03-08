package com.yy.example.data_structure;

import com.google.common.collect.Lists;

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
        method3(map);

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
     * <pre>
     *  使用Collections.sort(list, valueComparator); + 重写Comparator方法
     *  list.sort(valueComparator)
     *  list.stream().sorted(valueComparator)
     * </pre>
     *
     * @param map
     */
    public static void method3(final Map<String, Integer> map) {
        final List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());

        /**
         * ------------- 使用Collections.sort()方法排序 ----------------
         */
        /*Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {

                return o2.getValue() - o1.getValue();
            }
        });
        Collections.sort(list, (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));
        Collections.sort(list, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        Collections.sort(list, Map.Entry.comparingByValue());*/


        /**
         * ------------- list.sort()方法排序 -------------
         */
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {

                return o2.getValue() - o1.getValue();
            }
        });
        list.sort((Map.Entry<String, Integer> h1, Map.Entry<String, Integer> h2) -> h1.getValue().compareTo(h2.getValue()));
        list.sort((h1, h2) -> h1.getValue().compareTo(h2.getValue()));
        // 这种方式调用reversed()，需要getValue是static的，否则报错
        list.sort(Comparator.comparing(Map.Entry::getValue));
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        list.forEach(System.out::println);

        /**
         * ------------- list.stream().sorted()方法排序 -------------
         */
        final List<Map.Entry<String, Integer>> newList = list.stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {

                return o2.getValue() - o1.getValue();
            }
        }).collect(Collectors.toList());
        list.stream().sorted((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));
        list.stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        // 这条语句调用reversed()会报错，原因是需要getValue是static的，否则报错。 可以用(1)(2)方式解决这个问题
        list.stream().sorted(Comparator.comparing(Map.Entry::getValue));
        // (1)
        list.stream().sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)));
        // (2)
        list.stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
        // NB. 泛型的这种书写方式是错误的，(2)中的书写是对的
        // list.stream().sorted(Map.Entry<String, Integer>.comparingByValue().reversed());

        newList.forEach(System.out::println);


        /**
         * ------------- list.stream().sorted()方法排序后直接生成map -------------
         */
        final Map<String, Integer> map1 = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(e1 -> e1.getKey(),
                        e2 -> e2.getValue(), (e1, e2) -> e1, HashMap::new));


        /**
         * ------------- 对自定义对象进行自定义排序方法从而实现排序 -------------
         */
        final List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
        humans.sort(Human::compareByNameThenAge);
        // humans.forEach(System.out::println);
    }


}

class Human {
    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human(final String name, final int age) {
        super();

        this.name = name;
        this.age = age;
    }

    public static int compareByNameThenAge(final Human lhs, final Human rhs) {
        if (lhs.name.equals(rhs.name)) {
            return lhs.age - rhs.age;
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }
    // standard getters and setters
}
