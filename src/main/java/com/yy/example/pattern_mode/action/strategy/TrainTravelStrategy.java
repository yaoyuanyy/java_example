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
public class TrainTravelStrategy extends TravelStrategy{

    public TrainTravelStrategy(String name) {
        super(name);
    }

    @Override
    public void route(){
        System.out.println("路线：北京-->武汉-->宿迁");
    }

    @Override
    public void durationTime(){
        System.out.println("时间：需要10小时");
    }

    @Override
    public String advantage(){
        System.out.println("特点：可以躺着睡觉，休息好，感受火车的乐趣");
        return "";
    }
}
