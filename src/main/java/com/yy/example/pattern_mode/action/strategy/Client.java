package com.yy.example.pattern_mode.action.strategy;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-28 at 15:31
 */
public class Client {

    public static void main(String[] args) {

        TravelStrategy travelStrategy = new PlaneTravelStrategy("乘坐飞机：");
        Context context = new Context(travelStrategy);
        context.travel();

        System.out.println("------ 现在想换一个出行方式，改成坐火车的方式 ------");
        // 现在想换一个出行方式，改成坐火车的方式
        travelStrategy = new TrainTravelStrategy("坐火车");
        context.setStrategy(travelStrategy);
        context.travel();
    }
}
