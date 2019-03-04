package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.spring_aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 18:25
 */
public class CustomProxyFactory {

    public static ProxyFactory getProxyObject(Class clazz, Object target){
        ProxyFactory factory = new ProxyFactory();
        factory.addInterface(clazz);
        factory.addAdvice(new ParemterMethodBeforeAdvice());
        factory.addAdvice(new CustomMethodAfterAdvice());
        factory.setExposeProxy(true);
        factory.setTarget(target);
        return factory;
    }
}
