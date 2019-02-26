package com.yy.example.pattern_mode.structure.proxy.static_proxy.inherit;

/**
 * 代理Tank类，即：Tank类的方法前后加上自己的东西(即方法执行时间)
 * Created by skyler on 2017/3/17.
 */
public class TankLogProxy extends Tank{

    @Override
    public void move() {
        System.out.println("start move...");
        super.move();
        System.out.println("end move...");
    }
}
