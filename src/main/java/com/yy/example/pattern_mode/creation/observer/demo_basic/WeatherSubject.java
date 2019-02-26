package com.yy.example.pattern_mode.creation.observer.demo_basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/12 at 下午3:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherSubject extends Subject{

    /**
     * 晴天？雨天? 多云？
     */
    private String name;
    /**
     * 温度
     */
    private float temperature;
    /**
     * 湿度
     */
    private float humidity;

    public void change(){
        this.noticeObservers();
    }
}
