package com.yy.example.pattern_mode.proxy.dynamic_proxy.cglib.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/11/29 at 下午11:38
 */
public class MyMethodInterceptor implements MethodInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        logger.info("jia le log");
        return methodProxy.invoke(o, args);
    }
}
