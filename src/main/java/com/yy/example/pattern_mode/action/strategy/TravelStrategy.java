package com.yy.example.pattern_mode.action.strategy;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-28 at 15:05
 */
public abstract class TravelStrategy {

    protected String name;

    public TravelStrategy(String name) {
        this.name = name;
    }

    public abstract void route();

    public abstract void durationTime();

    public abstract String advantage();
}
