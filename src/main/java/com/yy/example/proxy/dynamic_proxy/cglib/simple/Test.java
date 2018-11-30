package com.yy.example.proxy.dynamic_proxy.cglib.simple;


import com.yy.example.proxy.dynamic_proxy.cglib.HelloImp;
import org.springframework.cglib.proxy.Enhancer;

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
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloImp.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloImp helloImp = (HelloImp) enhancer.create();
        System.out.println(helloImp.sayHello("hello"));
    }
}
