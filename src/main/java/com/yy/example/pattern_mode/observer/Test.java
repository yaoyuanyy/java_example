package com.yy.example.pattern_mode.observer;

/**
 * Created by skyler on 2017/3/4.
 */
public class Test {
    public static void main(String[] args) {
        // new 被观察者实现类
        WeatherData weatherData = new WeatherData();
        // new 观察者实现类, 观察者实现类实现了展示内容接口
        Display display = new WeatherDisplay(weatherData);
        // 被观察者改变数据
        weatherData.setMeasument(80,60,40);


        System.out.println("------------");


        TrafficData trafficData = new TrafficData();
        new TrafficDisplay(trafficData);
        trafficData.setNewData(new Traffic(11,"beiyuanlu", false));


    }
}
