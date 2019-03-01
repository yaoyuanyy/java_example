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
public class HeilongjiangTravel extends Travel {

    public HeilongjiangTravel(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("吃锅包肉，大盆凉菜，杀猪菜");
    }

    @Override
    public void live() {
        System.out.println("住在马迭尔宾馆，天天路过中央大街");
    }

    @Override
    public void traffic() {
        System.out.println("出门做马车，雪橇");
    }

    @Override
    public void duration() {
        System.out.println("在黑龙江玩2天");
    }
}
