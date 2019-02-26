package com.yy.example.pattern_mode.creation.single;

/**
 * Created by skyler on 2017/3/8.
 */
public class Test {

    public static void main(String[] args) {

        Singleten instance = Singleten.getInstance();
        System.out.println(instance);
        instance = Singleten.getInstance();
        System.out.println(instance);
    }
}
