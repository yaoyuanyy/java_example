package com.yy.example.pattern_mode.action.observer.demo_complex;

/**
 * Description: 观察者{@link Observer}实现类
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 上午11:24
 */
public class TrafficDisplay implements Observer, Display{

    private Subject trafficData;
    public TrafficDisplay(Subject subject) {
        this.trafficData = subject;
        trafficData.registerObserver(this);
    }

    @Override
    public void display() {

    }

    @Override
    public void update(Data data) {
        System.out.println(data);
    }
}
