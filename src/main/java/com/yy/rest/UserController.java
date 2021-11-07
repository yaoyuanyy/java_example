package com.yy.rest;

import com.yy.config.ResponseObj;
import com.yy.example.java.java8.Person;
import com.yy.service.IUserService;
import io.netty.handler.codec.http.DefaultHttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

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

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //webDataBinder.registerCustomEditor();

    }

    @Autowired
    private IUserService userService;

    @RequestMapping("/hello")
    public Mono<String> hello(@RequestBody Publisher<Person> publisher) {
        log.info("param:{}", publisher);
        return Mono.just("success");
    }

    @GetMapping("/test")
    @CrossOrigin("http://localhost2")
    public Flux<Person> test(ServerHttpRequest serverHttpRequest) {
        return Flux.just(new Person());
    }

    /**
     * localhost:8088/test2/11?name=22;age=33
     * @param id
     * @param age
     * @param request
     * @return
     */
    @GetMapping("/test2/{id}")
    public Flux<Person> test2(@PathVariable("id") Integer id, @MatrixVariable Integer age, ServerHttpRequest request) {
        log.info("id:{} age:{}", id, age);

        return Flux.just(new Person());
    }

    /**
     * 报错："No primary or default constructor found for class io.netty.handler.codec.http.DefaultHttpRequest
     * 看来netty的HttpRequest不能直接用于spring web接收页面的参数数据
     *
     * @param httpRequest
     * @return
     */
    @RequestMapping("/test2")
    public Flux<Person> test2(DefaultHttpRequest httpRequest) {

        log.info("param:{}", httpRequest.uri());
        return Flux.just(new Person());
    }

//    @RequestMapping("/test3")
//    public Mono<ServerResponse> test3(DefaultHttpRequest httpRequest) throws URISyntaxException {
//
//        log.info("param:{}", httpRequest.uri());
//
//        return ServerResponse.ok()
//                .location(new URI(httpRequest.uri()))
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromObject(new Person("name", "name2")));
//
//    }

    @RequestMapping("/query_one")
    public ResponseObj queryOne() {
        return ResponseObj.success(userService.getById(1L));
    }

    /**
     * -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/yaoliang/Documents -Xmx20m -Xms20m -Xmn10m -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCCause
     *
     * JVM Option argv: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution
     *
     * -XX:+UseConcMarkSweepGC -XX:+ExplicitGCInvokesConcurrent -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/yaoliang/Documents -Xmx200m -Xms200m -Xmn100m -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCCause -jar /Users/yaoliang/skyler/project/mytest/test/java_example-0.0.1-SNAPSHOT.jar
     *
     * @param step
     * @param capacity
     * @return
     */
    @GetMapping("/testJVMGC")
    public ResponseObj testJVMGC(@RequestParam("step") Integer step, @RequestParam("capacity") Integer capacity, @RequestParam("systemGC") Integer systemGC) {
        List<PersonObj> list = new ArrayList<>();

        if(systemGC == 1) {
            System.gc();
            return ResponseObj.success("success 手动调用 System.gc() systemGC == 1");
        }
        // 创建n个1M大小的数组，耗尽内存
        for (int i = 0; i < step; i++) {
            list.add(new PersonObj("women" + i, i, new byte[1024 * 1024 * capacity]));
        }

        if(systemGC == 2) {
            System.gc();
            return ResponseObj.success("success 手动调用 System.gc() systemGC == 2");
        }

        return ResponseObj.success("success list.size:" + list.size());
    }

    @GetMapping("/testJVMGC-systemGC")
    public ResponseObj testJVMGCSystemGC(@RequestParam("systemGC") Integer systemGC) {
       System.gc();

       return ResponseObj.success("success 手动调用 System.gc()");
    }

    /**
     * <pre>
     * <font color=green size=5>服务器推送事件</font>
     *   服务器推送事件（Server-Sent Events，SSE）允许服务器端不断地推送数据到客户端。
     *   相对于 WebSocket 而言，服务器推送事件只支持服务器端到客户端的单向数据传递。
     *   虽然功能较弱，但优势在于 SSE 在已有的 HTTP 协议上使用简单易懂的文本格式来表示传输的数据。
     *   作为 W3C 的推荐规范，SSE 在浏览器端的支持也比较广泛，除了 IE 之外的其他浏览器都提供了支持。
     *   在 IE 上也可以使用 polyfill 库来提供支持。在服务器端来说，SSE 是一个不断产生新数据的流，非常适合于用反应式流来表示。
     *   在 WebFlux 中创建 SSE 的服务器端是非常简单的。只需要返回的对象的类型是 Flux<ServerSentEvent>，就会被自动按照 SSE 规范要求的格式来发送响应。
     * </pre>
     *
     * @return
     */
//    @GetMapping("/randomNumbers")
//    public Flux<ServerSentEvent<Integer>> randomNumbers() {
//        return Flux.interval(Duration.ofSeconds(1))
//                .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
//                .map(data -> ServerSentEvent.<Integer>builder()
//                        .event("random")
//                        .id(Long.toString(data.getT1()))
//                        .data(data.getT2())
//                        .build());
//    }


    //----------------------------------------------\
    //     一个简单的计算器来展示函数式编程模型的用法     |
    //----------------------------------------------/

    @GetMapping("/add")
    public Mono<ServerResponse> add(final ServerRequest request) {
        return calculate(request, (v1, v2) -> v1 + v2);
    }

    @GetMapping("/subtract")
    public Mono<ServerResponse> subtract(final ServerRequest request) {
        return calculate(request, (v1, v2) -> v1 - v2);
    }

    @GetMapping("/multiply")
    public Mono<ServerResponse>  multiply(final ServerRequest request) {
        return calculate(request, (v1, v2) -> v1 * v2);
    }

    @GetMapping("/divide")
    public Mono<ServerResponse> divide(final ServerRequest request) {
        return calculate(request, (v1, v2) -> v1 / v2);
    }

    private Mono<ServerResponse> calculate(final ServerRequest request, final BiFunction<Integer, Integer, Integer> calculateFunc) {

        final Tuple2<Integer, Integer> operands = extractOperands(request);
        return ServerResponse.ok().body((Mono.just(calculateFunc.apply(operands.getT1(), operands.getT2()))), Integer.class);
    }


    private Tuple2<Integer, Integer> extractOperands(final ServerRequest request) {
        return Tuples.of(parseOperand(request, "v1"), parseOperand(request, "v2"));
    }

    private int parseOperand(final ServerRequest request, final String param) {
        try {
            return Integer.parseInt(request.queryParam(param).orElse("0"));
        } catch (final NumberFormatException e) {
            return 0;
        }
    }

}


