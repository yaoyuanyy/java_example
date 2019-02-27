package com.yy.example.pattern_mode.action.observer.complex;

/**
 * 观察者{@link Observer}实现类
 * Created by skyler on 2017/3/4.
 */
public class WeatherDisplay implements Observer, Display {

    // 数据来源是被观察者
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherSubject;

    public WeatherDisplay(Subject weatherSubject) {
        this.weatherSubject = weatherSubject;
        weatherSubject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("temperature:"+temperature+" humidity:"+humidity+" pressure:"+pressure);
    }

    @Override
    public void update(Data data) {
        if (data instanceof Weather){
            Weather weather = (Weather) data;
            // 把被观察者的数据存下来，留做他用
            this.temperature = weather.getTemperature();
            this.humidity = weather.getHumidity();
            this.pressure = weather.getPressure();
        }

        // 可以直接显示数据
        display();
    }

}
