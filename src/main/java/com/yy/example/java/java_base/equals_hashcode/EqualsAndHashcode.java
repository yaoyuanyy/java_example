package com.yy.example.java.java_base.equals_hashcode;

import java.util.HashMap;

public class EqualsAndHashcode {

    public static void main(String[] args) {

        Student s1 = new Student(10, "a", 5);
        Student s11 = new Student(10, "a", 5);

        System.out.println("s1 == s11:" + (s1 == s11));
        System.out.println(s1.equals(s11));
        System.out.println(s1.hashCode() == s11.hashCode());

        HashMap<Student, String> map = new HashMap<>();
        map.put(s1, "aa");
        map.put(s11, "bb");

        System.out.println("map:" + map);

        Student s2 = new Student(5, "b", 10);

        Student s3 = new Student(8, "c", 2);

    }

}
