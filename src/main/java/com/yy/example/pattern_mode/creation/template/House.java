package com.yy.example.pattern_mode.creation.template;

/**
 * Description: 模版 房子
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午8:46
 */
public abstract class House {

    abstract void eat();
    abstract long high();
    abstract void sleep();

    public void action(){

        System.out.println("---行为开始---");
        eat();
        high();
        sleep();
        System.out.println("---行为结束---");
    }
}
