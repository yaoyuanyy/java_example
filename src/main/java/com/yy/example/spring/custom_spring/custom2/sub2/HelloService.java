package com.yy.example.spring.custom_spring.custom2.sub2;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/15 at 下午7:55
 */
@Slf4j
public class HelloService {

    private Long id;

    public void setId(Long id) {
        log.info(" --- HelloService setId:{}", id);
        this.id = id;
    }

    public HelloService(){
        log.info(" --- HelloService constructor");
    }

    public void sayHello(){
        log.info("say hello");
    }
}
