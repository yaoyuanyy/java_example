package com.yy.test;


import com.yy.JavaExampleApp;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

/**
 * test case base class, extend it if you define a test case class
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {JavaExampleApp.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JavaExampleAppTest implements ApplicationContextAware {

    @Autowired
    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
