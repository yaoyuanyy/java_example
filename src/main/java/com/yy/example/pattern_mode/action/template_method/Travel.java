package com.yy.example.pattern_mode.action.template_method;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 * </pre>
 * <p>
 * Created by skyler on 2019-02-28 at 18:22
 */
public abstract class Travel {

    protected String name;

    public Travel(String name) {
        this.name = name;
    }

    /**
     * template method，被final修饰
     */
    public final void play(){
        // 吃住行，游玩天数
        System.out.println("游玩地点：" + name);
        eat();
        live();
        traffic();
        duration();
    }


    public abstract void eat();

    public abstract void live();

    public abstract void traffic();

    public abstract void duration();
}
