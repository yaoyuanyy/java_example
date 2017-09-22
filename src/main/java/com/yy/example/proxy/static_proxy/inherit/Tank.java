package com.yy.example.proxy.static_proxy.inherit;

/**
 * Created by skyler on 2017/3/17.
 */
public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("Tank is Moving");
    }
}
