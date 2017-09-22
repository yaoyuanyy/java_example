package com.yy.example.pattern_mode.decorator;

/**
 * 被装饰者的一个子类
 * 饮料的一种
 * desc:
 * Created by skyler on 2017/3/4
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    double cost() {
        return 1.99;
    }
}