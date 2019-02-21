package com.yy.rest;

import com.yy.config.ResponseObj;
import com.yy.example.java8.Person;
import com.yy.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Description:
 * <p></p>
 * <pre>
 *     https://cloud.tencent.com/developer/article/1034728
 * </pre>
 * NB.
 * Created by skyler on 2017/12/4 at 下午6:44
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/hello")
    public Mono<String> hello(@RequestBody Publisher<Person> publisher) {
        log.info("param:{}", publisher);
        return Mono.just("success");
    }

    @RequestMapping("/test")
    public Flux<Person> test(ServerHttpRequest serverHttpRequest) {

        log.info("param:{}", serverHttpRequest.getPath().contextPath().value());

        return Flux.just(new Person());
    }

    @RequestMapping("/query_one")
    public ResponseObj queryOne() {
        return ResponseObj.success(userService.getById(1L));
    }
}


