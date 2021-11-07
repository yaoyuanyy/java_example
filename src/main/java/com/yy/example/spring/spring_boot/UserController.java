package com.yy.example.spring.spring_boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * <p>
 * NB.
 * </p>
 * Created by skyler on 2019-07-10 at 11:26
 */
@RestController("consumerController")
@EnableConfigurationProperties(User.class)
@Slf4j
public class UserController {

    @Autowired
    private User user;

    @RequestMapping("/getUser")
    public User getUser(){
        log.info("user hash code:{}", user.hashCode());
        return user;
    }
}
