package com.yy.config;

import com.yy.annotation.CustomClass2IOC;
import com.yy.custom_spring.custom2.CustomBeanDefinitionResgistryPostProcessor;
import com.yy.custom_spring.custom4.HelloService;
import com.yy.custom_spring.custom5.InstantiationService;
import com.yy.custom_spring.custom6.CustomBeanFactoryPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/9/29 at 下午5:06
 */
@Configuration
@Import(value = {MultiThreadConfig.class})
@CustomClass2IOC(targets = {HelloService.class})
@Slf4j
@EnableWebFlux
public class AppConfig implements WebFluxConfigurer {

    @Bean
    public CustomBeanDefinitionResgistryPostProcessor customBeanDefinitionResgistryPostProcessor(){
        log.info("CustomBeanDefinitionResgistryPostProcessor @bean start");
        return new CustomBeanDefinitionResgistryPostProcessor();
    }

    //@Bean
//    public CustomInstantiationAwarePostProcessorAdapter customInstantiationAwarePostProcessorAdapter(){
//        log.info("customInstantiationAwarePostProcessorAdapter @bean start");
//        return new CustomInstantiationAwarePostProcessorAdapter();
//    }

    @Bean(initMethod = "initMethod")
    public InstantiationService instantiationService(){
        log.info("instantiationService @bean start");
        InstantiationService service = new InstantiationService();
        service.setId(100L);
        return service;
    }

    @Bean
    public static BeanFactoryPostProcessor customBeanFactoryPostProcessor(){
        return new CustomBeanFactoryPostProcessor();
    }
}
