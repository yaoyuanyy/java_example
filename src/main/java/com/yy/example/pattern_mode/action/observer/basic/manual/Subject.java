package com.yy.example.pattern_mode.action.observer.basic.manual;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 被观察者(主题) 基类
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午3:10
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void noticeObservers() {
        observers.forEach(o -> {
            o.update(this);
        });
    }
}
