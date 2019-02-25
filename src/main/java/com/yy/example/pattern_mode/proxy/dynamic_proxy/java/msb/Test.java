package com.yy.example.pattern_mode.proxy.dynamic_proxy.java.msb;

/**
 * Created by skyler on 2017/3/17.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Movable movable = (Movable) Proxy.newInstaceProxy(Movable.class, new TimeInvocationHandler(new Tank()));
        movable.move();
    }
}
