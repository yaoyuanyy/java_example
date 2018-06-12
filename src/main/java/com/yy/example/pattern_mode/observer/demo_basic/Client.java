package com.yy.example.pattern_mode.observer.demo_basic;

/**
 * Description:
 * <p></p>
 * <pre>
 *     refer to: https://blog.csdn.net/dd864140130/article/details/50877063
 * </pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午3:39
 */
public class Client {

    public static void main(String[] args) {
        WeatherSubject subject = new WeatherSubject("小雨", 20.3f, 40.0f);
        Observer observer1 = new SchoolObserver();
        Observer observer2 = new TrafficObserver();

        subject.attach(observer1);
        subject.attach(observer2);

        subject.noticeObservers();

        System.out.println("\n<-----------天气有变----------->\n");

        // 天气变了
        subject.setName("大雨");
        subject.setTemperature(10);
        subject.setHumidity(80);
        //发布最新指标
        subject.noticeObservers();
    }
}
