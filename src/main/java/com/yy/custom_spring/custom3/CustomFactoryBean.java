package com.yy.custom_spring.custom3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Description: 自定义FactoryBean，FactoryBean的每个实现类都是一个工厂，创建某一类bean的工厂。参考{@link org.springframework.aop.framework.ProxyFactoryBean}
 * <p></p>
 * <pre>
 *   Spring中有两种类型的Bean，一种是普通Bean，另一种是工厂Bean即FactoryBean，这两种Bean都被容器管理。
 *   工厂Bean是实现了org.springframework.beans.factory.FactoryBean<T>接口的Bean，从ApplicationContext的getBean()方法获取的对象不是该类的一个实例，而是该类的getObject()方法所返回的对象。
 *   当我们需要获取FactoryBean实例本身而不是它所产生的bean，则要使用&符号。
 *   比如，现有FactoryBean，id为”playerBean”，在容器上调用getBean("playerBean")将返回FactoryBean产生的bean。调用getBean("&playerBean")将返回FactoryBean它本身的实例。
 *
 *   原文：https://blog.csdn.net/soonfly/article/details/69485549?utm_source=copy
 *
 *   test case: CustomSpringComponentTest.testCustomFactoryBean()
 * </pre>
 * <p>
 * Created by skyler on 2018/10/16 at 下午3:07
 */
@Slf4j
@Component
public class CustomFactoryBean implements FactoryBean<HelloCustomFactoryBean>{

    @Override
    public HelloCustomFactoryBean getObject() throws Exception {
        log.info(" --- CustomFactoryBean.getObject");
        return new HelloCustomFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        log.info(" --- CustomFactoryBean.getObjectType");
        return HelloCustomFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        log.info(" --- CustomFactoryBean.isSingleton");
        return true;
    }
}
