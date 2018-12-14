package com.yy.custom_spring.custom5;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   refer to https://www.cnblogs.com/xrq730/p/5721366.html
 * </pre>
 * <p>
 * Created by skyler on 2018/10/16 at 下午6:22
 */
@Slf4j
@Component
public class CustomInstantiationAwarePostProcessorAdapter extends InstantiationAwareBeanPostProcessorAdapter{

    public CustomInstantiationAwarePostProcessorAdapter() {
        log.info(" --- CustomInstantiationAwarePostProcessorAdapter constructor");
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) {
        if(beanClass.isAssignableFrom(InstantiationService.class)){
            //log.info(" --- CustomInstantiationAwarePostProcessorAdapter predictBeanType beanClass:{} beanName:{}", beanClass, beanName);
        }
        return super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass.isAssignableFrom(InstantiationService.class)){
            log.info(" --- CustomInstantiationAwarePostProcessorAdapter determineCandidateConstructors beanClass:{} beanName:{}", beanClass, beanName);
        }
        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if(bean instanceof InstantiationService) {
            log.info(" --- CustomInstantiationAwarePostProcessorAdapter getEarlyBeanReference bean:{} beanName:{}", bean, beanName);
        }
        return super.getEarlyBeanReference(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass.isAssignableFrom(InstantiationService.class)) {
            log.info(" --- CustomInstantiationAwarePostProcessorAdapter postProcessBeforeInstantiation beanClass:{} beanName:{}", beanClass, beanName);
        }
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof InstantiationService) {
            log.info(" --- CustomInstantiationAwarePostProcessorAdapter postProcessAfterInstantiation bean:{} beanName:{}", bean, beanName);
        }
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if(bean instanceof InstantiationService) {
            //log.info(" --- CustomInstantiationAwarePostProcessorAdapter postProcessPropertyValues bean:{} beanName:{} PropertyValues:{} PropertyDescriptor:{}",
                   // bean, beanName, JSON.toJSONString(pvs), JSON.toJSONString(pds));
        }
        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof InstantiationService) {
            log.info(" --- CustomInstantiationAwarePostProcessorAdapter postProcessBeforeInitialization bean:{} beanName:{}", bean, beanName);
        }
        return super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof InstantiationService) {
            log.info(" --- CustomInstantiationAwarePostProcessorAdapter postProcessAfterInitialization bean:{} beanName:{}", bean, beanName);
        }
        return super.postProcessAfterInitialization(bean, beanName);
    }
}
