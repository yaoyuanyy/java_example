package com.yy.example.pattern_mode.action.strategy;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-28 at 15:05
 */
public class CarTravelStrategy extends TravelStrategy{

    public CarTravelStrategy(String name) {
        super(name);
    }

    @Override
    public void route(){
        System.out.println("路线：北京-->沧州-->武汉-->江苏-->宿迁");
    }

    @Override
    public void durationTime(){
        System.out.println("时间：需要36小时");
    }

    @Override
    public String advantage(){
        System.out.println("特点：欣赏路边的风景，结实好朋友");
        return "";
    }
}
