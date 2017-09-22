package com.yy.example.pattern_mode.single;

/**
 * Created by skyler on 2017/3/8.
 */
public class Singleten {

    private static Singleten instance = new Singleten();

    private Singleten(){}

    public static Singleten getInstance() {
        return instance;
    }
}
