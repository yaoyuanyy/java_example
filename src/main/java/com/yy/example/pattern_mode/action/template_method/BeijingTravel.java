package com.yy.example.pattern_mode.action.template_method;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-01 at 10:43
 */
public class BeijingTravel extends Travel {

    public BeijingTravel(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("老北京小吃，豆汁，小点心");
    }

    @Override
    public void live() {
        System.out.println("住在北京饭店，对面就是故宫");
    }

    @Override
    public void traffic() {
        System.out.println("出门开着共享汽车");
    }

    @Override
    public void duration() {
        System.out.println("预计在北京玩3天");
    }
}
