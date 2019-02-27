package com.yy.example.pattern_mode.action.observer.basic.auto;

import com.yy.example.pattern_mode.action.observer.basic.manual.Observer;
import com.yy.example.pattern_mode.action.observer.basic.manual.Subject;

/**
 * Description: 我们希望操作是异步的,并且只有在观察者被注册到被观察者上时,被观察者才生效
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午5:29
 */
public class AsynSubject extends Subject{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private OnAttach onAttach;

    public AsynSubject(OnAttach onAttach) {
        this.onAttach = onAttach;
    }

    @Override
    public void attach(Observer observer) {
        onAttach.call(this, observer);
    }

    /**
     * 回调事件：负责通知观察者
     */
    interface OnAttach{
        void call(Subject subject,Observer observer);
    }
}
