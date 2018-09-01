package com.yy.rest;

import com.yy.example.java8.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/4 at 下午6:44
 */
@RestController
@Slf4j
public class TestController {

//    ThreadFactory factory = new BasicThreadFactory.Builder().namingPattern("test-multi-thread-%d").build();
//
//    ThreadPoolExecutor executor = new ThreadPoolExecutor(210,220,10, TimeUnit.MILLISECONDS,
//            new SynchronousQueue<>());

    private static int i = 0;

    @RequestMapping("/hello")
    public String hello(final Person person) {
        try{
            int i = 10/0;
        }catch (Exception e){
            log.error("方法{} error", "hello", e);
        }
//    for (int i = 0; i < 1000; i++){
//        executor.execute(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("current-thread:"+Thread.currentThread().getName());
//        });
//    }
        System.out.println(person);

        return "success";
    }

    @RequestMapping("/test")
    public String test() {
        i++;
        System.out.println("^^^:"+i);

        return "success";
    }

    @RequestMapping("/ex")
    public String ex() {
        throw new IllegalArgumentException("ddd");
    }
}


