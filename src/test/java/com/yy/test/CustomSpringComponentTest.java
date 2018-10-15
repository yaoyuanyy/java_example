package com.yy.test;

import com.yy.custom_spring.Hello;
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


public class CustomSpringComponentTest extends AppTest{

    @Autowired
    private Hello hello;

    /**
     * 测试自定义的 BeanDefinitionResgistryPostProcessor
     * {@linkplain com.yy.custom_spring.CustomBeanDefinitionResgistryPostProcessor} and {@link com.yy.config.AppConfig#customBeanDefinitionResgistryPostProcessor()}
     */
    @Test
    public void test(){
        Assert.notNull(hello, "hello object must be not null");
        System.out.println(hello);
    }
}
