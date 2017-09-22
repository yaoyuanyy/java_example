package com.yy.example.pattern_mode.observer;

/**
 * Created by skyler on 2017/3/4.
 */
public class TestObserver {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Observer observer = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasument(80,60,40);
        System.out.println("");
    }
}
