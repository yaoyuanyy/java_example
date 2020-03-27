package com.yy.example.pattern_mode.action.observer.basic.auto.advance_1;

import com.yy.example.pattern_mode.action.observer.complex.Traffic;
import com.yy.example.pattern_mode.action.observer.complex.Weather;

import java.time.LocalDateTime;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/13 at 上午11:27
 */
public class ClientJinJie1 {

    public static void main(String[] args) {

        /**
         * 主题为交通
         */
        // 被观察者
        Subject trafficSubject = Subject.create(new Subject.OnAttach<Traffic>() {

            @Override
            public void call(Traffic traffic, Observer observer) {
                observer.update(traffic);
            }
        });

        trafficSubject.setT(new Traffic(10, "shangdi donglu", false));

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

        /**
         * 主题为天气
         */
        // 被观察者
        Subject weatherSubject = Subject.create(new Subject.OnAttach<Weather>() {

            @Override
            public void call(Weather weather, Observer observer) {
                observer.update(weather);
            }
        });

        weatherSubject.setT(new Weather(10, 20, 30));

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
