package com.yy.example.pattern_mode.action.observer.demo_complex;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者({@link Subject})实现类
 * Created by skyler on 2017/3/4.
 */
public class WeatherSubject implements Subject {

    /**
     * <pre>
     * 有人可能认为观察者集合放到接口(Subject)里更合适。
     * 因为不同的被观察者通知的观察者不一定是相同的，如：
     * WeatherData要通知的是WeatherDisplay，而TrafficData要通知的是TrafficDisplay
     * 所以，被通知者们关联到具体的通知者是恰当的
     */
    private List<Observer> observers;

    private Weather weather;

    public WeatherSubject() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach( o ->
            o.update(weather)
        );
    }

    public void setMeasument(final float temperature, final float humidity,final float pressure) {
        weather = new Weather(temperature, humidity, pressure);

        this.notifyObservers();
    }
}
