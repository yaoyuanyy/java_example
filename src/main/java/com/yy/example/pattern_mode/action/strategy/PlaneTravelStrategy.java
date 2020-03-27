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
public class PlaneTravelStrategy extends TravelStrategy {

    public PlaneTravelStrategy(String name) {
        super(name);
    }

    @Override
    public void route(){
        System.out.println("路线：北京-->宿迁");
    }

    @Override
    public void durationTime(){
        System.out.println("时间：需要2小时");
    }

    @Override
    public String advantage(){
        System.out.println("特点：速度快，不耽误时间");
        return "";
    }
}
