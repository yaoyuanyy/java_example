package com.yy.example.pattern_mode.action.strategy;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-28 at 15:29
 */
public class Context {

    private TravelStrategy strategy;

    public Context(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void travel(){
        strategy.route();
        strategy.durationTime();
        strategy.advantage();
    }
}
