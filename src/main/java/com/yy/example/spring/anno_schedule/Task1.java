package com.yy.example.spring.anno_schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task1 {

    @Scheduled(fixedRate = 3000)
    public void syn() throws InterruptedException {
        System.out.println("syn: "+new Date());
        Thread.sleep(1000*8);
    }

//    @Async
//    @Scheduled(fixedRate = 3000)
//    public void asyn() throws InterruptedException {
//        System.out.println("asyn: "+new Date());
//        Thread.sleep(1000*8);
//    }
//
//    @Async
//    @Scheduled(cron = "*/3 * * * * *")
//    public void asyn2() throws InterruptedException {
//        System.out.println("asyn2: "+new Date());
//        Thread.sleep(1000*8);
//    }
}
