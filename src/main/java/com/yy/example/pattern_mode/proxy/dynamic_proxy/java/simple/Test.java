package com.yy.example.pattern_mode.proxy.dynamic_proxy.java.simple;


import java.lang.reflect.Proxy;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/11/29 at 下午11:18
 */
public class Test {

    public static void main(String[] args) {
        Hello hello = (Hello) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{Hello.class},new LogInvocationHandler(new HelloImp()));
        System.out.println(hello.sayHello("hello"));
    }
}
