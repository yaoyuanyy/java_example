package com.yy.example.pattern_mode.action.observer.complex;

/**
 * Created by skyler on 2017/3/4.
 */
public class Test {
    public static void main(String[] args) {
        // new 被观察者实现类，即主题
        WeatherSubject weatherSubject = new WeatherSubject();
        // new 观察者实现类, 观察者实现类实现了展示内容接口
        Display display = new WeatherDisplay(weatherSubject);
        // 被观察者改变数据
        weatherSubject.setMeasument(80,60,40);


        System.out.println("------------");


        TrafficSubject trafficSubject = new TrafficSubject();
        new TrafficDisplay(trafficSubject);
        trafficSubject.setNewData(new Traffic(11,"beiyuanlu", false));


    }
}
