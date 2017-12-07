package com.yy.example.pattern_mode.factory_method.tutorial2;

/**
 * Created by skyler on 2017/3/7.
 */
public class PizzaType {

    public enum Chicago{
        White,Black,Common
    }

    public enum NewYork{
        Deep,Thin,Common
    }

    private Chicago chicago;
    private NewYork newYork;

    public Chicago getChicago() {
        return chicago;
    }

    public void setChicago(Chicago chicago) {
        this.chicago = chicago;
    }

    public NewYork getNewYork() {
        return newYork;
    }

    public void setNewYork(NewYork newYork) {
        this.newYork = newYork;
    }
}
