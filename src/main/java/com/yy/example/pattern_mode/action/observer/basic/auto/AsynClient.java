package com.yy.example.pattern_mode.action.observer.basic.auto;

import com.yy.example.pattern_mode.action.observer.basic.manual.Observer;
import com.yy.example.pattern_mode.action.observer.basic.manual.Subject;
import com.yy.example.pattern_mode.action.observer.basic.manual.Client;

import java.time.LocalDateTime;

/**
 * Description: 实现自动通知
 * <p></p>
 * <pre>
 *     我们在AsynSubject中定义OnAttach接口,该接口负责通知观察者.
 *     同时attach方法在将观察者注册到被观察者上之后,会调用OnAttach的call方法来实现自动通知,
 *     这样做的好处就是我们不需要再手动调用call方法来通知被观察者了--对用户屏蔽细节
 *
 *     而手动通知的方式见{@link Client}
 * </pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午5:33
 */
public class AsynClient {

    /**
     * <pre>
     * 第一步
     * AsynSubject asynSubject = new AsynSubject(new AsynSubject.OnAttach() {
     *      @Override
     *      public void call(Subject subject, Observer observer) {
     *          observer.update(subject);
     *      }
     * });
     *
     * 第二步
     * 48行 通过匿名类的方式定义一个观察者并调用attach方法来注册到被观察者上，由于attach()方法实现：
     * public class AsynSubject extends Subject{
     *    @Override
     *    public void attach(Observer observer) {
     *        onAttach.call(this, observer);
     *    }
     * }
     * 所以会调用onAttach.call(this, observer)方法，而其实第一步定义好了
     *
     * 通过上面两步，从而实现自动通知的功能
     * </pre>
     * @param args
     */
    public static void main(String[] args) {

        // 定义一个被观察者，这个被观察者带了一个内部接口，这个内部接口可以自动通知观察者
        AsynSubject asynSubject = new AsynSubject(new AsynSubject.OnAttach() {
            @Override
            public void call(Subject subject, Observer observer) {
                observer.update(subject);
            }
        });

        // 更新信息，观察者显示最新信息
        asynSubject.setName("ddd");

        // 定义一个观察者，并将观察者(临时)注册到被观察者上。此观察者是一个匿名类，匿名类生命周期短，有利于回收
        asynSubject.attach(new Observer() {
            @Override
            public void update(Subject subject) {
                if(subject instanceof AsynSubject) {
                    AsynSubject as = (AsynSubject)subject;
                    System.out.println("天气：" + as.getName());
                    System.out.println("异步监测站\n 当前时间：" + LocalDateTime.now());
                }
            }
        });

        // 这里不需要再手动调用asynSubject.noticeObservers()了

    }
}
