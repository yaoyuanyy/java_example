package com.yy.example.pattern_mode.abstractFactory.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public ShuCai createShuCai() {
        System.out.println(this.getClass().getName()+"doing Tomato");
        return new Tomato();
    }

    @Override
    public Meat createMeat() {
        System.out.println(this.getClass().getName()+"doing Beef");
        return new Beef();
    }
}
