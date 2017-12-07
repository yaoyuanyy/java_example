package com.yy.rest;

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
public class PersonController {

    @RequestMapping("/hello")
    public String hello(Person person) {
        System.out.println(person);

        return "success";
    }
}


