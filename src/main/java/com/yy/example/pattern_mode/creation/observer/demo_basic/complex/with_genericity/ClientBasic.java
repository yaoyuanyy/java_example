package com.yy.example.pattern_mode.creation.observer.demo_basic.complex.with_genericity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/13 at 上午11:27
 */
public class ClientBasic {

    public static void main(String[] args) {

        // 被观察者
        Subject subject = Subject.create(new Subject.OnAttach() {

            @Override
            public void call(Subject subject, Observer observer) {
                observer.update(new ArrayList(Arrays.asList(1, 2, 3, 4)));
            }
        });

        // 观察者
        subject.attach(new Observer<ArrayList<Integer>>() {
            @Override
            public void update(ArrayList<Integer> list) {
                /**
                 * 泛型带来的好处：有个泛型，就不需要if(subject instanceof AsynSubject)判断了，说明方法时就已经明确入参类型了
                 */
//                if(subject instanceof AsynSubject) {
//                    AsynSubject as = (AsynSubject)subject;
//                    System.out.println("天气：" + as.getName());
//                    System.out.println("异步监测站\n 当前时间：" + LocalDateTime.now());
//                }

                list.forEach(System.out::println);
            }
        });

    }
}
