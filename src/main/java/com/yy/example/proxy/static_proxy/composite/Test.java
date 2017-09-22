package com.yy.example.proxy.static_proxy.composite;

/**
 * Created by skyler on 2017/3/17.
 */
public class Test {
    public static void main(String[] args) {
        Tank tank = new Tank();
        TankLogProxy tankLogProxy = new TankLogProxy(tank);
        TankTimeProxy tankTimeProxy = new TankTimeProxy(tankLogProxy);
        tankTimeProxy.move();

        System.out.println("---------------------------------");

        TankTimeProxy tankTimeProxy2 = new TankTimeProxy(tank);
        TankLogProxy tankLogProxy2 = new TankLogProxy(tankTimeProxy2);
        tankLogProxy2.move();

    }
}
