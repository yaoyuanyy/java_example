package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.java.simple2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   参考 https://segmentfault.com/a/1190000009235245
 * </pre>
 * <p>
 * @see com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.cglib.simple2.ProxyFactory#ProxyFactory(Object) cglib代理方式
 * </p>
 * Created by skyler on 2019-02-25 at 16:07
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyObject(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy class name:" + proxy.getClass().getName());
                // 执行额外的操作 如日志，事务，时间，
                // 执行目标对象方法
                return method.invoke(target, args);
            }
        });
    }
}
