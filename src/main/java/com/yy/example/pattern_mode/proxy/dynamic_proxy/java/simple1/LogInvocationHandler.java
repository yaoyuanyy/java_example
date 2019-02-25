package com.yy.example.pattern_mode.proxy.dynamic_proxy.java.simple1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/11/29 at 下午11:16
 */
public class LogInvocationHandler implements InvocationHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Object target;
    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("sayHello".equals(method.getName())) {
            logger.info("You said: " + Arrays.toString(args));
        }
        addLog();
        return method.invoke(target, args);
    }

    public void addLog(){
        logger.info("jia le log");
    }
}
