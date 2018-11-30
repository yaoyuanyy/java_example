package com.yy.example.proxy.dynamic_proxy.java.msb;

import java.lang.reflect.Method;

/**
 * Created by skyler on 2017/3/19.
 */
public interface InvocationHandler {
    void invoke(Object o,Method m);
}
