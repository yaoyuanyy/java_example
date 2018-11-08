package com.yy.test;

import com.yy.custom_spring.custom2.Hello;
import com.yy.custom_spring.custom2.CustomBeanDefinitionResgistryPostProcessor;
import com.yy.custom_spring.custom3.HelloCustomFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

/**
 * Description: 自定义的spring 组件测试用例
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/9/29 at 下午5:31
 */

@Slf4j
public class CustomSpringComponentTest extends AppTest{

    @Autowired
    private Hello hello;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HelloCustomFactoryBean helloCustomFactoryBean;

    /**
     * 测试自定义的 BeanDefinitionResgistryPostProcessor
     * {@linkplain CustomBeanDefinitionResgistryPostProcessor} and {@link com.yy.config.AppConfig#customBeanDefinitionResgistryPostProcessor()}
     */
    @Test
    public void testCustomBeanDefinitionResgistryPostProcessor(){
        Assert.notNull(hello, "hello object must be not null");
        System.out.println(hello);
    }

    /**
     * 测试自定义的 FactoryBean
     * {@link com.yy.custom_spring.custom3.CustomFactoryBean}}
     */
    @Test
    public void testCustomFactoryBean(){
        Assert.notNull(helloCustomFactoryBean, "helloCustomFactoryBean object must be not null");
        // output --> bean info:HelloCustomFactoryBean(id=null, clazz=null, className=null)
        log.info("bean info:{}",applicationContext.getBean("customFactoryBean"));

        // output --> bean info:com.yy.custom_spring.CustomFactoryBean@4f169009
        log.info("bean info:{}",applicationContext.getBean("&customFactoryBean"));
    }
}
