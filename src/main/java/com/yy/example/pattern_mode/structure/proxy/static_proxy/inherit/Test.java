package com.yy.example.pattern_mode.structure.proxy.static_proxy.inherit;

/**
 * Created by skyler on 2017/3/17.
 */
public class Test {
    public static void main(String[] args) {
        TankTimeProxy tankTimeProxy = new TankTimeProxy();
        tankTimeProxy.move();
        System.out.println("");
    }
}
