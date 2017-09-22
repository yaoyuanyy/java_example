package com.yy.example.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class Java8Test {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("lll"));

        Function<String, Integer> toInteger = Integer::valueOf;
        System.out.println(toInteger.apply("111"));

        Supplier<String> personSupplier = String::new;
        String s = personSupplier.get();
        System.out.println(s);

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));

        List<Person> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
       /* list.parallelStream().map((p) -> p.getFirstName()).collect(Collectors.toList()).forEach( s33 -> {
            System.out.println(s33);
            s33.toString();
            list2.add(s33);
        });*/

        list.parallelStream().collect(Collectors.toList()).forEach( s33 -> {
            System.out.println(s33);
            s33.toString();
            list2.add(s33.getFirstName());
        });

        list.parallelStream()
                .filter(p -> p.getFirstName().contains("1"))
                .map(Person::getLastName)// 返回一个新的stream<T>
                .collect(Collectors.toList())
                .forEach((sr) -> {
                    System.out.println(sr);
                    list2.toArray();
                });

        Optional<String> optional = Optional.of("null");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((sw) -> System.out.println(sw.charAt(0)));

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((key, val) -> {
            System.out.println(val.contains("d"));
        });

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33
        map.remove(3, "val3");

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        map.getOrDefault(42, "not found");  // not found

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
    }
}

