package com.yy.example.pattern_mode.action.template;

/**
 * Description: 模版子类 平房
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午9:00
 */
public class OneStoreyHouse extends House {

    @Override
    void eat() {
        System.out.println("在厨房吃饭");
    }

    @Override
    long high() {
        System.out.println("平房的高度一般是三米");

        return 3;
    }

    @Override
    void sleep() {
        System.out.println("在炕上睡觉");
    }
}
