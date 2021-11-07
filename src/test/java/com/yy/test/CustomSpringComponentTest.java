package com.yy.test;

import com.yy.example.spring.custom_spring.custom3.HelloC;
import com.yy.example.spring.custom_spring.custom2.sub1.Hello;
import com.yy.example.spring.custom_spring.custom2.sub1.CustomBeanDefinitionResgistryPostProcessor;
import com.yy.example.spring.custom_spring.custom3.CustomFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Description: 自定义的spring 组件测试用例
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/9/29 at 下午5:31
 */

@Slf4j
public class CustomSpringComponentTest extends JavaExampleAppTest {

    @Autowired
    private Hello hello;
    @Autowired
    private HelloC helloC;

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
     * {@link CustomFactoryBean}}
     */
    @Test
    public void testCustomFactoryBean(){
        Assert.notNull(helloC, "HelloC object must be not null");
        // output --> bean info:HelloC(id=null, clazz=null, className=null)
        log.info("bean info:{}",webApplicationContext.getBean("customFactoryBean"));

        // output --> bean info:com.yy.custom_spring.CustomFactoryBean@4f169009
        log.info("bean info:{}",webApplicationContext.getBean("&customFactoryBean"));
    }
}
