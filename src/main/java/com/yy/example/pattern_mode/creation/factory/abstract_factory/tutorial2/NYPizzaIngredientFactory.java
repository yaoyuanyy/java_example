package com.yy.example.pattern_mode.creation.factory.abstract_factory.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public ShuCai createShuCai() {
        System.out.println(this.getClass().getName()+"doing Cuke");
        return new Cuke();
    }

    @Override
    public Meat createMeat() {
        System.out.println(this.getClass().getName()+"doing Mutton");
        return new Mutton();
    }
}
