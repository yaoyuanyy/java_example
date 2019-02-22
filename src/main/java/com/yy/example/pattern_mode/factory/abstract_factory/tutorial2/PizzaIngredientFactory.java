package com.yy.example.pattern_mode.factory.abstract_factory.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public interface PizzaIngredientFactory {

    ShuCai createShuCai();
    Meat createMeat();
}
