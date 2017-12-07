package com.yy.example.pattern_mode.abstractFactory.tutorial2;

/**
 * desc:
 * Created by skyler on 2017/3/7
 */
public class Test {
    public static void main(String[] args) {
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        Pizza p = new CheesePizza(pizzaIngredientFactory);

        p.prepare();
        System.out.println("--------------------------------");
        pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        p = new CheesePizza(pizzaIngredientFactory);

        p.prepare();
    }
}