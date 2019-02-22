package com.yy.example.pattern_mode.factory.abstract_factory.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing ...");
        pizzaIngredientFactory.createShuCai();
        pizzaIngredientFactory.createMeat();
        System.out.println("CheesePizza coming ...");

    }

}
