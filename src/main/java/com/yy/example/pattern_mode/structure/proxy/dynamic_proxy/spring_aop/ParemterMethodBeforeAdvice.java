package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.spring_aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 18:43
 */
public class ParemterMethodBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if("address".equals(method.getName())){
            System.out.println(method.getGenericReturnType().getTypeName());
            System.out.println("target:" + target.getClass().getName());
        }
    }
}
