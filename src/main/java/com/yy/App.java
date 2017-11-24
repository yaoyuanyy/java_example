package com.yy;

import com.yy.util.DoubleUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@SpringBootApplication
//@EnableAsync
//@EnableScheduling
public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("app"+new Date());
        SpringApplication.run(App.class, args);
        double d = DoubleUtil.divide(10,1,2);
        System.out.println("d value: "+d);
    }

}
