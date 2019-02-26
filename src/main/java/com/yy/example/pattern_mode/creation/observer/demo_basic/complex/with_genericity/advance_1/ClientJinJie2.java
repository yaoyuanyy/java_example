package com.yy.example.pattern_mode.creation.observer.demo_basic.complex.with_genericity.advance_1;

import com.yy.example.pattern_mode.creation.observer.demo_complex.Traffic;
import com.yy.example.pattern_mode.creation.observer.demo_complex.Weather;

import java.time.LocalDateTime;

/**
 * Description: 相比较jinjie1, Subject.create()调用时就会传入实际主题场景(如Traffic)，避免需要另赋初值
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/13 at 上午11:27
 */
public class ClientJinJie2 {

    public static void main(String[] args) {

        // 被观察者
        Subject trafficSubject = Subject.create(new Traffic(20, "上地三街", true), new Subject.OnAttach<Traffic>() {

            @Override
            public void call(Traffic traffic, Observer observer) {
                observer.update(traffic);
            }
        });

        // 观察者
        trafficSubject.attach(new Observer<Traffic>() {
            @Override
            public void update(Traffic traffic) {
                /**
                 * 泛型带来的好处：有个泛型，就不需要if(subject instanceof AsynSubject)判断了，说明方法时就已经明确入参类型了
                 */
//                if(subject instanceof AsynSubject) {
//                    AsynSubject as = (AsynSubject)subject;
//                    System.out.println("天气：" + as.getName());
//                    System.out.println("异步监测站\n 当前时间：" + LocalDateTime.now());
//                }

                System.out.println("交通监测站\n 当前时间：" + LocalDateTime.now());
                System.out.println("街道：" + traffic.getStreet());
                System.out.println("车数量：" + traffic.getCarCount());

            }
        });

        System.out.println("<--------通过泛型实现灵活产生不同的主题，播报不同的实时信息------->");

        // 被观察者
        Subject weatherSubject = Subject.create(new Weather(10, 20, 30), new Subject.OnAttach<Weather>() {

            @Override
            public void call(Weather weather, Observer observer) {
                observer.update(weather);
            }
        });

        //更新最新信息
        weatherSubject.setT(new Weather(15, 50, 50));

        // 观察者
        weatherSubject.attach(new Observer<Weather>() {
            @Override
            public void update(Weather weather) {
                /**
                 * 泛型带来的好处：有个泛型，就不需要if(subject instanceof AsynSubject)判断了，说明方法时就已经明确入参类型了
                 */
//                if(subject instanceof AsynSubject) {
//                    AsynSubject as = (AsynSubject)subject;
//                    System.out.println("天气：" + as.getName());
//                    System.out.println("异步监测站\n 当前时间：" + LocalDateTime.now());
//                }

                System.out.println("天气监测站\n 当前时间：" + LocalDateTime.now());
                System.out.println("温度：" + weather.getTemperature());
                System.out.println("气压：" + weather.getPressure());
                System.out.println("湿度：" + weather.getHumidity());
            }
        });

    }
}
