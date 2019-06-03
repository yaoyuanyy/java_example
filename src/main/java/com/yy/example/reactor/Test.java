package com.yy.example.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**`
 * Description:
 * <pre>
 *
 * </pre>
 * <p>
 * NB.
 * </p>
 * Created by skyler on 2019-06-03 at 17:28
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        testFlux();

        // testMono();

    }

    public static void testFlux(){
        System.out.println("test Flux start --- ");

        // Flux.just(1,2,3).subscribe(System.out::println);


        Flux.just(1,2,3,"4", new Exception("error")).log().subscribe((s) -> System.out.println(s + " thread:" + Thread.currentThread().getName())
                , error -> System.err.println(error + " error thread:" + Thread.currentThread().getName())
                , () -> System.out.println("completed thread:" + Thread.currentThread().getName()));


        Object[] array = {1,2,3,4,5,6};
        Flux.fromArray(array).doOnNext((a) -> {
            System.out.println("a: " + a + "回调OnNext方法");
        }).subscribe(new BaseSubscriber<Object>() {


            @Override
            protected void hookOnNext(Object value) {
                System.out.println("value:" + value + " hookOnNext");
            }
        });

        Flux.range(1, 10).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                // n: 表示限制执行item次数
                s.request(3);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext:" + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        });

        // interval();
    }


    public static void interval(){
        Flux.interval(Duration.ofSeconds(1)).map(sec -> Long.toString(sec)).subscribe(System.out::println);

        // 等待Flux.interval的执行，否则程序结束了，Flux.interval还没执行呢
        try {
            Thread.sleep(2000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testMono(){
        System.out.println("test mono start --- ");
        Mono.just(1).subscribe(System.out::println);

        Mono.just(1).single().subscribe(System.out::println);
    }
}
