package com.yy.example.pattern_mode.action.template_method;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-01 at 10:46
 */
public class Client {

    public static void main(String[] args) {

        BeijingTravel beijingTravel = new BeijingTravel("北京游玩");
        beijingTravel.play();

        System.out.println("--------------------");

        HeilongjiangTravel heilongjiangTravel = new HeilongjiangTravel("黑龙江游玩");
        heilongjiangTravel.play();
    }
}
