package com.yy.example.pattern_mode.proxy.static_proxy.inherit;

/**
 * 代理Tank类，即：Tank类的方法前后加上自己的东西(即方法执行时间)
 * Created by skyler on 2017/3/17.
 */
public class TankTimeProxy extends TankLogProxy{

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("take time: " + (end - start));
    }
}
