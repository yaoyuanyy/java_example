package com.yy.example.spring.anno_schedule;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task2 {

    //@Scheduled(fixedDelay = 4000)
    public void t() throws InterruptedException {
        System.out.println("task2: "+new Date());
        Thread.sleep(1000*5);
    }
}
