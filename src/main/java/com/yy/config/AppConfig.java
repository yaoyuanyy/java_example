package com.yy.config;

import com.yy.custom_spring.CustomBeanDefinitionResgistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/9/29 at 下午5:06
 */
@Configuration
@Import(MultiThreadConfig.class)
public class AppConfig {

    @Bean
    public CustomBeanDefinitionResgistryPostProcessor customBeanDefinitionResgistryPostProcessor(){
        return new CustomBeanDefinitionResgistryPostProcessor();
    }
}
