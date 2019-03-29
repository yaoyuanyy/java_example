package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.spring_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-06 at 07:17
 */
@Aspect
@Component
public class TimeFeeAspect {


    @Pointcut("execution(* com.yy..rest..*(..))")
    public void cut(){}

    @Before("cut()")
    public void doTimeFeeIntercepter(JoinPoint joinPoint) throws Throwable {

        System.out.println("args:" + joinPoint.getArgs());
        System.out.println("target" + joinPoint.getTarget().toString());
        System.out.println("" + joinPoint.getThis().toString());

    }

}
