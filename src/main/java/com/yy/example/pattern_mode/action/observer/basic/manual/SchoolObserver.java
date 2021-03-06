package com.yy.example.pattern_mode.action.observer.basic.manual;

import java.time.LocalDateTime;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午3:38
 */
public class SchoolObserver implements Observer{

    @Override
    public void update(Subject subject) {
        System.out.println("==============");

        if(subject instanceof WeatherSubject) {

            WeatherSubject weatherSubject = (WeatherSubject)subject;

            // 大屏幕展示当前最新的指数
            System.out.println("学校监测站\n 当前时间：" + LocalDateTime.now());
            System.out.format("天气：%s\n 温度：%f\n 湿度：%f\n", weatherSubject.getName(), weatherSubject.getTemperature(), weatherSubject.getHumidity());

            // 如果指标到达危险指数，学生提前放学
            // ......
        }
    }
}
