package com.yy.reactive;

import com.yy.config.ResponseObj;
import com.yy.example.java8.Person;
import com.yy.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/4 at 下午6:44
 */
@RestController
@Slf4j
@RequestMapping("/reactor-user")
public class ReactiveUserController {

    @Autowired
    private IUserService userService;
    private static int i = 0;

    @RequestMapping("/hello")
    public Mono<Person> hello(final Person person) {
        return Mono.justOrEmpty(new Person());
    }

    @RequestMapping("/test")
    public Mono<String> test() {

        return Mono.just("hello");
    }
    @GetMapping("/randomNumbers")
    public Flux<ServerSentEvent<Integer>> randomNumbers() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                .map(data -> ServerSentEvent.<Integer>builder()
                        .event("random")
                        .id(Long.toString(data.getT1()))
                        .data(data.getT2())
                        .build());
    }

}


