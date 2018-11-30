package com.yy.example.proxy.dynamic_proxy.cglib.simple2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 * <p></p>
 * <pre>
 *  https://segmentfault.com/a/1190000013735171
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018-11-30 at 07:49
 */
public class ProxyFactory implements MethodInterceptor {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        addLog();
        Object obj = methodProxy.invoke(target, args);
        System.out.println("recond return value");
        return obj;
    }

    public void addLog(){
        System.out.println("add log");
    }

    public void recond(){
        System.out.println("recond return value");
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
