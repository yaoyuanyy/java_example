package com.yy.example.pattern_mode.observer.demo_basic.complex.with_genericity.advance_1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午5:29
 */
public class Subject<T>{

    private T t;

    private OnAttach onAttach;

    public Subject(OnAttach onAttach) {
        this.onAttach = onAttach;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static <T> Subject<T> create(OnAttach<T> onAttach) {
        return new Subject(onAttach);
    }

    // 进阶2
    public Subject(T t, OnAttach onAttach) {
        this.t = t;
        this.onAttach = onAttach;
    }
    // 进阶2
    public static <T> Subject create(T t, OnAttach<T> onAttach) {
        return new Subject(t, onAttach);
    }


    public void attach(Observer observer) {
        onAttach.call(t, observer);
    }

    /**
     * 回调事件：负责通知观察者
     */
    interface OnAttach<T>{
        void call(T t, Observer observer);
    }
}
