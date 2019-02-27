package com.yy.example.pattern_mode.action.observer.basic.auto.with_genericity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/13 at 上午11:27
 */
public class AdvanceClient {

    public static void main(String[] args) {

        // 被观察者，这个被观察者附带一个内部类，其功能为回调对象
        Subject subject = Subject.create(new Subject.OnAttach() {

            // 回调函数
            @Override
            public void call(Subject subject, Observer observer) {
                observer.update(new ArrayList(Arrays.asList(1, 2, 3, 4)));
            }
        });

        // 观察者
        Observer observer = new Observer<ArrayList<Integer>>() {
            @Override
            public void update(ArrayList<Integer> list) {;/**
                 * 泛型带来的好处：有个泛型，就不需要if(subject instanceof AsynSubject)判断了，说明方法时就已经明确入参类型了
                 */
//                if(subject instanceof AsynSubject) {
//                    AsynSubject as = (AsynSubject)subject;
//                    System.out.println("天气：" + as.getName());
//                    System.out.println("异步监测站\n 当前时间：" + LocalDateTime.now());
//                }

                list.forEach(System.out::println);
            }
        };

        // 被观察者通知观察者
        subject.attach(observer);

    }
}
