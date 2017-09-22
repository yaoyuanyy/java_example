package com.yy.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		
		// 把一个Collection转化为Stream
		// 实际应用对比：从person的集合中取出firstName放到另一个集合中
		List<Person> persons = new ArrayList<>();
		Collections.addAll(persons, new Person("11", "111"), new Person("12", "112"));
		// java7
		List<String> names = new ArrayList<String>();
		for (Person person : persons) {
			names.add(person.getFirstName());
		}
		
		
		// java8
		list.stream().map(Person::getLastName).collect(Collectors.toList());
		list.parallelStream().map(Person::getLastName).collect(Collectors.toList());//并行
		
		
		list.stream().parallel().filter((p) -> p.getFirstName().contains("1")) //过滤
				.forEach((pp) -> System.out.println("pp:" + pp.getFirstName() + "thread:" + Thread.currentThread()));
		
		List<String> list2 = new ArrayList<>();

		list.parallelStream().filter(p -> p.getFirstName().contains("1")).<String>map(Person::getLastName)// 返回一个新的stream<T>
		.collect(Collectors.toList()).forEach((sr) -> {
			System.out.println(sr);
			list2.toArray();
		});

		List<String> values = Arrays.asList("1", "2", "3");
		String sum = values.stream().reduce("", (a, rrr) -> a + rrr);
		String sum2 = values.stream().reduce("", String::concat);
		System.out.println(sum);

        System.out.println( "a"+getInt("dd", s ->s.equals("dd")));

	}

	public static int getInt(Object o, Predicate predicate) {
	    if(predicate.test(o)) {
	        return 0;
        }
	    return 1;
    }

}
