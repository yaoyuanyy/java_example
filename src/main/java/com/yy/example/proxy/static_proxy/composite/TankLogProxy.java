package com.yy.example.proxy.static_proxy.composite;


/**
 * 代理Tank类，记录真实对象方法日志信息的代理类。即：Tank类的方法前后加上自己的东西(即方法执行时间)
 * Created by skyler on 2017/3/17.
 */
public class TankLogProxy  implements Movable{

    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("start move...");
        movable.move();
        System.out.println("end move...");
    }

    @Override
    public void stop() {
        System.out.println("start move...");
        movable.stop();
        System.out.println("end move...");
    }
}
