package com.yy.example.pattern_mode.structure.proxy.static_proxy.composite;

/**
 * Created by skyler on 2017/3/17.
 */
public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("Tank is Moving");
    }

    @Override
    public void stop() {
        System.out.println("Tank is stoping");
    }
}
