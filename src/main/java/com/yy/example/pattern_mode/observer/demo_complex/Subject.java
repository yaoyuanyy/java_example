package com.yy.example.pattern_mode.observer.demo_complex;

/**
 * 被观察者
 * Created by skyler on 2017/3/4.
 */
public interface Subject {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
