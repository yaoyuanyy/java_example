package com.yy.example.java.java8;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class InnerFuntionalsTest {

	public static void main(String[] args) {
		/*Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("lll"));*/

		Function<String, Integer> toInteger = Integer::valueOf;
		System.out.println(toInteger.apply("111"));

		Supplier<Person> personSupplier = Person::new;
		Person p = personSupplier.get();
		System.out.println("p:"+p);

		Consumer<Person> greeter = (pp) -> System.out.println("Hello, " + pp.getFirstName());
		greeter.accept(new Person("Luke", "Skywalker"));

		String s="dfdsfdf";
		Optional<String> optional = Optional.ofNullable(s);
		optional.isPresent(); // true
		optional.get(); // "bam"
		optional.orElse("fallback"); // "bam"
		optional.ifPresent((sw) -> System.out.println(sw.charAt(0)));
	}
}
