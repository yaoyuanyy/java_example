package com.yy.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * <p></p>
 * <pre>
 *     {@link org.springframework.web.servlet.mvc.method.annotation.CallableMethodReturnValueHandler}
 *   http://niels.nu/blog/2016/spring-async-rest.html
 * </pre>
 * <p>
 * Created by skyler on 2018/10/21 at 下午6:11
 */
@Slf4j
@RestController
@RequestMapping(value = "/time")
public class AsyncController {

    private final AtomicInteger counter = new AtomicInteger(0);

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public TimeResponse timeBasic() {
        log.info("Basic time request");
        return now();
    }

    @RequestMapping(value = "/re", method = RequestMethod.GET)
    public ResponseEntity<?> timeResponseEntity() {
        log.info("Response entity request");
        return ResponseEntity.ok(now());
    }

    @RequestMapping(value = "/callable", method = RequestMethod.GET)
    public Callable<ResponseEntity<?>> timeCallable() {
        log.info("Callable time request");
        return () -> ResponseEntity.ok(now());
    }

    @RequestMapping(value = "/deferred", method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<?>> timeDeferred() {
        log.info("Deferred time request");
        DeferredResult<ResponseEntity<?>> result = new DeferredResult<>();

        new Thread(() -> {
            result.setResult(ResponseEntity.ok(now()));
        }, "MyThread-" + counter.incrementAndGet()).start();

        return result;
    }

    private static TimeResponse now() {
        log.info("Creating TimeResponse");
        return new TimeResponse(LocalDateTime
                .now()
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
