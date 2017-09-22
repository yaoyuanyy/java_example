package com.yy.example.pattern_mode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyler on 2017/3/4.
 */
public class WeatherData implements Subject {

    private List<Observer> observers;
    float temperature;
    float humidity;
    float pressure;

    public WeatherData() {
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
            o.update(temperature, humidity, pressure)
        );
    }

    public void setMeasument(float temperature, float humidity ,float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.notifyObservers();
    }
}
