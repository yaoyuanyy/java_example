package com.yy.example.java8;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
		List<Integer> elements = new ArrayList<>();
//		for(int i=0 ; i< 10000 ; i++) {
//			elements.add(i);
//		}
//		List<Integer> matched = elements.parallelStream()
//				.filter(e -> e >= 100)
//				.collect(Collectors.toList());
//		System.out.println(matched.size());

		List<String> values = Arrays.asList("1", "2", "3");
		String sum = values.stream().reduce("", (a, rrr) -> a + rrr);
		String sum2 = values.stream().reduce("", String::concat);
		System.out.println(sum);

        System.out.println( "a"+getInt("dd", s ->s.equals("dd")));
		for(int i=0 ; i< 100 ; i++) {
			System.out.println(JSON.toJSONString(IntStream.range(0,5).parallel().map(x -> x*2).toArray()));
		}


		int _sum = 2;
		for (int x : new int[]{1,2,3}) {
			_sum += x;
		}
		System.out.println(_sum);

		int _sum2 = Arrays.asList(new Integer[]{1,2,3}).stream().reduce(2, (x,y) -> x+y);
		System.out.println(_sum2);

		int _sum3 = Arrays.asList(new Integer[]{1,2,3}).stream().reduce(2, (a, b) -> a + 1 + b, Integer::sum);
		System.out.println(_sum3);
	}

	public static int getInt(Object o, Predicate predicate) {
	    if(predicate.test(o)) {
	        return 0;
        }
	    return 1;
    }

}
