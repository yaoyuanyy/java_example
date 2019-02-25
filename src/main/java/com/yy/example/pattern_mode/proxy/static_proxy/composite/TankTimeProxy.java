package com.yy.example.pattern_mode.proxy.static_proxy.composite;


/**
 * 代理Tank类，记录真实对象方法执行时间的代理类。即：Tank类的方法前后加上自己的东西(即方法执行时间)
 * Created by skyler on 2017/3/17.
 */
public class TankTimeProxy implements Movable{

    Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println("take time:" + (end - start));
    }

    @Override
    public void stop() {
        long start = System.currentTimeMillis();
        movable.stop();
        long end = System.currentTimeMillis();
        System.out.println("take time:" + (end - start));
    }

}
