package com.yy.example.pattern_mode.creation.template;

/**
 * Description: 模版子类 楼房
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午9:00
 */
public class MoreStoreyHouse extends House {

    @Override
    void eat() {
        System.out.println("在客厅吃饭");
    }

    @Override
    long high() {
        System.out.println("楼房的高度一般是三十米");

        return 3;
    }

    @Override
    void sleep() {
        System.out.println("在床上睡觉");
    }
}
