package com.yy.example.java8;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MethodReferencesTest {

	public static void main(String[] args) {
		// 1. 使用内部类
		Function<Integer, String> f = new Function<Integer, String>() {
		    @Override
		    public String apply(Integer t) {
		        return String.valueOf(t);
		    }
		};
		System.out.println(f.apply(111));

		// 2. 使用 Lambda 表达式
		Function<Integer, String> f2 = (t)->String.valueOf(t);
		System.out.println(f2.apply(222));

		// 3. 使用方法引用的方式
		Function<Integer, String> f1 = String::valueOf;
		System.out.println(f1.apply(333));

		
		Person[] persons = {new Person("11", "111"), new Person("12", "112")};
		Arrays.sort(persons, Person::compareFirstNames);//静态方法
		Arrays.sort(persons, Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));//实例方法
	}
}
