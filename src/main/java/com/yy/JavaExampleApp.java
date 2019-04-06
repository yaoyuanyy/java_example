package com.yy;

import com.yy.util.DoubleUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Date;

@SpringBootApplication
@EnableAsync
// @EnableScheduling
@EnableKafka
public class JavaExampleApp {

    public static void main(String[] args) throws Exception {

        // 将jvm中的代理对象输出到硬盘的.class文件 方法一
        // --该设置用于输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/yaoliang/skyler/project/mytest/java_example");

        // --该设置用于输出jdk动态代理产生的类，输出的文件路径为your project下。如我的项目是java_example, $ProxyX.class在java_example/com/sun/proxy/下
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        System.out.println("app" + new Date());
        SpringApplication.run(JavaExampleApp.class, args);
        double d = DoubleUtil.divide(10, 1, 2);
        System.out.println("d value: " + d);
    }


}
