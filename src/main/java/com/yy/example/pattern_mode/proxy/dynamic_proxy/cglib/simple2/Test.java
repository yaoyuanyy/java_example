package com.yy.example.pattern_mode.proxy.dynamic_proxy.cglib.simple2;


import com.yy.example.pattern_mode.proxy.dynamic_proxy.cglib.HelloImp;

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
        HelloImp helloImp  = (HelloImp)new ProxyFactory(new HelloImp()).getProxyInstance();
        System.out.println(helloImp.sayHello("skyler"));
    }
}
