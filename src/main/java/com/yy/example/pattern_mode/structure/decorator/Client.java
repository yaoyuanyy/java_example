package com.yy.example.pattern_mode.structure.decorator;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 06:57
 */
public class Client {

    public static void main(String[] args) {
        House house = new SkylerHouse();
        System.out.println("我房子的信息：" + house.getInternalInfo());

        System.out.println("==================");

        House house1 = new ShuFangDecorator(house);
        System.out.println("我房子的信息：" + house1.getInternalInfo());

        System.out.println("==================");

        House house2 = new BingxiangDecorator(house1);
        System.out.println("我房子的信息：" + house2.getInternalInfo());

    }
}
