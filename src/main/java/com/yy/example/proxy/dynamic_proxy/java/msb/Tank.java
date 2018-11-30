package com.yy.example.proxy.dynamic_proxy.java.msb;

/**
 * Created by skyler on 2017/3/17.
 */
public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("Tank is Moving");
    }

  /*  @Override
    public void stop() {
        System.out.println("Tank is stoping");
    }*/
}
