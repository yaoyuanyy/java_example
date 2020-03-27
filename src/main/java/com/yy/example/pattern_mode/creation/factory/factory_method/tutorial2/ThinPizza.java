package com.yy.example.pattern_mode.creation.factory.factory_method.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public class ThinPizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("prepare,pizza:"+name);
    }

    @Override
    public void box() {
        System.out.println("Box,pizza:"+name);
    }
}
