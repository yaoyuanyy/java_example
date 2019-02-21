package com.yy.custom_spring.custom2.sub2;

import com.yy.annotation.CustomClass2IOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * Description: 通过自定义注解将指定注解的class属性值注入到bean Factory ioc中，用于后续使用
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/15 at 下午5:56
 */
@Slf4j
public class CustomImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar{
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        log.info("into CustomImportBeanDefinitionRegister.registerBeanDefinitions method");

        Map<String, Object> attributes = metadata.getAnnotationAttributes(CustomClass2IOC.class.getName(),false);
        Class<?>[] targets = (Class<?>[]) attributes.get("targets");
        if(null != targets && targets.length > 0){
            for (Class<?> target : targets) {
                log.info(" current custom class:{}", target);
                BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(target);
                registry.registerBeanDefinition(target.getName(), beanDefinitionBuilder.getBeanDefinition());
            }
        }
    }
}
