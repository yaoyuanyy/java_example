package com.yy.rest;

import com.yy.config.ResponseObj;
import com.yy.example.java8.Person;
import com.yy.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/4 at 下午6:44
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

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

    @RequestMapping("/query_one")
    public ResponseObj queryOne() {
        return ResponseObj.success(userService.getById(1L));
    }
}


