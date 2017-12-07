package com.yy.example.pattern_mode.factory_method.tutorial2;

/**
 * desc:
 * Created by skyler on 2017/3/7
 */
public class Test {
    public static void main(String[] args) {

        PizzaFactory pizzaFactory = new NewYorkPizzaFactory();
        PizzaType pizzaType = new PizzaType();
        pizzaType.setNewYork(PizzaType.NewYork.Deep);
        Pizza pizza = pizzaFactory.orderPizza(pizzaType);

        System.out.println("---------------------");

        pizzaFactory = new ChicagoPizzaFactory();
        pizzaType.setChicago(PizzaType.Chicago.Black);
        pizza = pizzaFactory.orderPizza(pizzaType);
    }
}