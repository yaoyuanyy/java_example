package com.yy.example.pattern_mode.creation.factory.factory_method.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public abstract class PizzaFactory {

    protected abstract Pizza creatPizza(PizzaType type);

    public Pizza  orderPizza(PizzaType type) {
        Pizza pizza;
        pizza = creatPizza(type);

        pizza.prepare();
        pizza.box();;

        return pizza;
    }
}
