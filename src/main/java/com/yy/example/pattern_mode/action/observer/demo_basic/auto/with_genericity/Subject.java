package com.yy.example.pattern_mode.action.observer.demo_basic.auto.with_genericity;

/**
 * Description: 主体，被观察者
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午5:29
 */
public class Subject{

    private OnAttach onAttach;

    public Subject(OnAttach onAttach) {
        this.onAttach = onAttach;
    }

    public static Subject create(OnAttach onAttach) {
        return new Subject(onAttach);
    }

    public void attach(Observer observer) {
        onAttach.call(this, observer);
    }

    /**
     * 回调事件：负责通知观察者
     */
    interface OnAttach{
        void call(Subject subject, Observer observer);
    }
}
