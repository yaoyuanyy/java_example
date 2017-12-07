package com.yy.example.pattern_mode.abstractFactory.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public abstract class Pizza {

    String name;
    ShuCai shuCai;
    Meat meat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();

    public void box() {
        System.out.println("abstract box");
    }
}
