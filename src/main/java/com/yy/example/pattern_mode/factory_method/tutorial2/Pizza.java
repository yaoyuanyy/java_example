package com.yy.example.pattern_mode.factory_method.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public abstract class Pizza {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void prepare(){
        System.out.println("abstract prepare");
    }
    public void box() {
        System.out.println("abstract box");
    }
}
