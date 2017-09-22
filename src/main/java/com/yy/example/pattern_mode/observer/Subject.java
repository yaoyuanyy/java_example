package com.yy.example.pattern_mode.observer;

/**
 * 主题(数据)
 * Created by skyler on 2017/3/4.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
