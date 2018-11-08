package com.yy.custom_spring.custom6;

import com.yy.custom_spring.custom5.InstantiationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Objects;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/18 at 上午7:42
 */
@Slf4j
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanNames = beanFactory.getBeanNamesForType(InstantiationService.class);

        if(Objects.nonNull(beanNames)){
            log.info("CustomBeanFactoryPostProcessor postProcessBeanFactory bean:{}",beanNames);
        }
    }
}
