package com.yy.example.java.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class Java8Test {

    public static void main(String[] args) {
        List<Person> people = init();

        listToMapWithKeyAttrValueObjectWithMax1(people);
        listToMapWithKeyAttrValueObjectWithMax2(people);
    }

    private static List<Person> init() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("A", "a", 100));
        people.add(new Person("B", "b", 50));
        people.add(new Person("C", "c", 10));
        people.add(new Person("C", "c2", 11));
        people.add(new Person("D", "d", 30));
        people.add(new Person("D2", "d", 31));
        people.add(new Person("E", "e", 10));
        people.add(new Person("F", "f", 90));
        return people;
    }

    /**
     * List<Object> to Map<Object.attr, Object>>
     *
     * NOTE: 以对象的一个字段a分组，并且相同字段a值的取另一个字段b的中数值较大的那个对象
     * @param people
     */
    private static void listToMapWithKeyAttrValueObjectWithMax1(List<Person> people) {
        Map<String, Person> map = people.stream().collect(Collectors.groupingBy(o -> o.getFirstName(),
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(o -> o.getAge())), Optional::get)));

        System.out.println("map:" + map);
    }

    /**
     * List<Object> to Map<Object.attr, Object>>
     *
     * NOTE: 以对象的一个字段a分组，并且相同字段a值的取另一个字段b的中数值较大的那个对象
     * @param people
     */
    private static void listToMapWithKeyAttrValueObjectWithMax2(List<Person> people) {
        Map<String, Person> map = people.stream().collect(Collectors.groupingBy(o -> o.getFirstName(),
                Collectors.collectingAndThen(Collectors.reducing((a, b) -> a.getAge() > b.getAge() ? a : b), Optional::get)));

        System.out.println("map:" + map);
    }

    /**
     * List<Object> to Map<Object.attr, Object>>
     *
     * NOTE: 以对象的一个字段a分组，并且相同字段a值的取另一个字段b的中数值较大的那个对象
     * @param people
     */
    private static void listToMapWithKeyAttrValueObjectWithMax3(List<Person> people) {
        Map<String, Optional<Person>> resultMap = people.stream().collect(
                Collectors.groupingBy(
                    o -> o.getFirstName(),
                    LinkedHashMap::new,
                    Collectors.maxBy(Comparator.comparing(Person::getAge))
                )
        );

        System.out.println("resultMap:" + resultMap);


        List<Person> persons = resultMap.values().stream().filter(person -> person.isPresent()).map(Optional::get).collect(Collectors.toList());
        System.out.println("persons:" + persons);
    }


    /**
     * List<Object> to Map<Object.attr, Set<Object>>>
     *
     * NOTE: 以对象的一个字段a分组，并且相同字段a值的取另一个字段b的中数值较大的那个对象
     * @param people
     */
    private static void listToMapWithKeyAttrValueSetObject(List<Person> people) {
        Map<String, HashSet<Person>> map = people.stream().collect(
                Collectors.groupingBy(
                        o -> o.getFirstName(),
                        Collectors.mapping(o -> o, Collectors.toCollection(HashSet::new))
                )
        );

        System.out.println("map:" + map);
    }

}

