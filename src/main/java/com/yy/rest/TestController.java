package com.yy.rest;

import com.yy.example.java8.Person;
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
public class TestController {

    private static int i = 0;

    @RequestMapping("/hello")
    public String hello(final Person person) {
        System.out.println(person);

        return "success";
    }

    @RequestMapping("/test")
    public String test() {
        i++;
        System.out.println("^^^:"+i);

        return "success";
    }
}

