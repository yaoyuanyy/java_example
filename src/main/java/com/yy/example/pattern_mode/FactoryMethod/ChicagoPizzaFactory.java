package com.yy.example.pattern_mode.FactoryMethod;

/**
 * 纽约的披萨工厂擅长生产各种颜色的pizza，如果客户要芝加哥的披萨工厂的披萨，
 * 只要建一个芝加哥披萨工厂(ChicagoPizzaFactory)同时继承披萨总厂(PizzaFactory)
 * Created by skyler on 2017/3/7.
 */
public class ChicagoPizzaFactory extends PizzaFactory{

    @Override
    protected Pizza creatPizza(PizzaType type) {
        Pizza pizza;
        switch (type.getChicago()) {
            case White:
                pizza = new WhitePizza();
                pizza.setName("White Pizza");
                break;
            case Black:
                pizza = new BlackPizza();
                pizza.setName("Black Pizza");
                break;
            default:
                pizza = new CommonPizza();
                pizza.setName("Common Pizza");
        }
        return pizza;
    }
}
