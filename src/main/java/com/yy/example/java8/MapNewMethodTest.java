package com.yy.example.java8;

import java.util.HashMap;
import java.util.Map;

public class MapNewMethodTest {
	public static void main(String[] args) {
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
        map.get(9); 
	}
}
