package com.yy.example.pattern_mode.template;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午9:04
 */
public class Test {

    public static void main(String[] args) {
        House house = new MoreStoreyHouse();
        house.action();

        System.out.println("-----------");
        House house2 = new OneStoreyHouse();
        house2.action();
    }
}
