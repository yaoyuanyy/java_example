package com.yy.example.pattern_mode.creation.observer.demo_basic.complex.with_genericity;

/**
 * Description: 观察者 接口
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午3:06
 */
public interface Observer<T> {

    /**
     *
     * @param subject
     */
    void update(T subject);
}
