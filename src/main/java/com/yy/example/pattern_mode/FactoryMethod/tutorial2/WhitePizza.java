package com.yy.example.pattern_mode.FactoryMethod.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public class WhitePizza extends Pizza {

    /*
     * 属性赋值尽量不要通过构造方法，因为构造方法的参数留给类型之间的引用更好，
     * 如WhitePizza(PizzaFactory pizzaFactory),这样有益于各种模式的搭建*/
    /* WhitePizza(String name){
        this.name = name;
    }*/

    @Override
    public void prepare() {
        System.out.println("prepare,pizza:"+name);
    }

    @Override
    public void box() {
        System.out.println("Box,pizza:"+name);
    }
}
