package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.spring_aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-04 at 10:31
 */
public class CustomMethodAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if("address".equals(method.getName())){
            System.out.println("return value:" + returnValue + " args:"+args + " target:" + target);
        }

    }
}
