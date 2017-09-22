package com.yy.example.java8;

import java.util.Arrays;
import java.util.Comparator;
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
		// 2. 使用 Lambda 表达式
		Function<Integer, String> f2 = (t)->String.valueOf(t);
		f2.apply(232);
		// 3. 使用方法引用的方式
		Function<Integer, String> f1 = String::valueOf;
		System.out.println(f1.apply(1));
		
		
		
		Person[] persons = {new Person("11", "111"), new Person("12", "112")};
		Arrays.sort(persons, Person::compareFirstNames);//静态方法
		Arrays.sort(persons, Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));//实例方法
	}
}
