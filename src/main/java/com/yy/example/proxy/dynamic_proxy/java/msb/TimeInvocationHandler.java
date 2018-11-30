package com.yy.example.proxy.dynamic_proxy.java.msb;

import java.lang.reflect.Method;

/**
 * Created by skyler on 2017/3/19.
 */
public class TimeInvocationHandler implements InvocationHandler {

    private Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        long start = System.currentTimeMillis();
        try {
            m.invoke(target);
        } catch (Exception e) {}
        long end = System.currentTimeMillis();
        System.out.println("take time:" + (end - start));
    }
}
