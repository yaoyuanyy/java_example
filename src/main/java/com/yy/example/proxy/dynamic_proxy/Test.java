package com.yy.example.proxy.dynamic_proxy;

/**
 * Created by skyler on 2017/3/17.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Movable movable = (Movable) Proxy.newInstaceProxy(Movable.class, new TimeInvocationHandler(new Tank()));
        movable.move();
    }
}
