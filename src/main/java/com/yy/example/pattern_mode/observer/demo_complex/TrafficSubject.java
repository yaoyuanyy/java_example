package com.yy.example.pattern_mode.observer.demo_complex;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:被观察者实现类
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 上午11:14
 */
public class TrafficSubject implements Subject{

    /**
     * <pre>
     * 有人可能认为观察者集合放到接口(Subject)里更合适。
     * 因为不同的被观察者通知的观察者不一定是相同的，如：
     * WeatherData要通知的是WeatherDisplay，而TrafficData要通知的是TrafficDisplay
     * 所以，被通知者们关联到具体的通知者是恰当的
     * </pre>
     */
    private List<Observer> observers;

    private Traffic traffic;

    public TrafficSubject(){
        this.observers = new ArrayList<>();
        this.traffic = new Traffic();
    }

    public TrafficSubject(Traffic traffic) {
        this.observers = new ArrayList<>();
        this.traffic = traffic;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setNewData(Traffic traffic){
        this.traffic = traffic;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(traffic));
    }
}
