package com.yy.example.reactor;

import com.yy.example.java.java8.Person;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * `
 * Description:
 * <pre>
 *
 * </pre>
 * <p>
 * NB.
 * </p>
 * Created by skyler on 2019-06-03 at 17:28
 */
public class Tutorial1 {

    public static void main(String[] args) throws InterruptedException {

//        testFlux();
//
//        testMono();
//        testFluxOprater();
//        testDefer();


        Flux.just(5, 10)
                .flatMap(x ->  Flux.interval(Duration.ofMillis(100)).take(x))
                .toStream()
                .forEach(System.out::println);

        System.out.println("-----");

        Flux.just(5, 10)
                .concatMap(x -> Flux.interval(Duration.ofMillis(100)).take(x))
                .toStream()
                .forEach(System.out::println);
    }

    public static void testFlux() {
        System.out.println("test Flux start --- ");

//        // 创建一个Flux，然后调用订阅
//        Flux flux = Flux.just(10);
//        flux.subscribe(System.out::println);
//
//        // 创建flux和调用订阅在一起链式完成
//        Flux.just(1,2,3).subscribe(System.out::println);
//
//        // subscribe(..)有多个重载方法，详细看其源码，这里列出最复杂的那个，里面的参数都是lambda方式实现
//        Flux.just(1,2,3,"4", new Exception("exception")).log().subscribe((s) -> System.out.println(s + " thread:" + Thread.currentThread().getName())
//                , error -> System.err.println(error + " error thread:" + Thread.currentThread().getName())
//                , () -> System.out.println("completed thread:" + Thread.currentThread().getName())
//                , subscription -> subscription.request(3));
//
//        // range(): 表示从5开始，依次+1创建10个数
//        // 此处的subscribe方法参数采用原始的方式创建，这个重载方式是继承Publisher的，这种形式是最本质的发布订阅模式的体现
//        Flux.range(5, 10).subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//                // n: 表示限制执行item次数，背压拉模式的实现方式
//                s.request(3);
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("onNext:" + integer);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("completed");
//            }
//        });

        // fromArray：从数组创建一个Flux
        // doOnNext方法：Add behavior (side-effect) triggered when the Flux emits an item
        // subscribe：重载方法采用BaseSubscriber的方式，增加了hook回调方法
        Object[] array = {1, 2, 3, 4, 5, 6};
        Flux.fromArray(array).doOnNext((a) -> System.out.println("a: " + a + "回调OnNext方法"))
                .subscribe(new BaseSubscriber<Object>() {
                    // Hook for processing of onNext values
                    @Override
                    protected void hookOnNext(Object value) {
                        request(3);
                        System.out.println("value:" + value + " hookOnNext");
                    }
                });


    }

    public static void testFluxOprater() {
        Flux.create((a) -> a.next(1)).subscribe(System.out::println);

        Flux.generate(a -> {
            a.next("generate test");
            //// a.next只能调用一次；否则 IllegalStateException: More than one call to onNext
            // a.next("generate test2");
            a.complete();
        }).subscribe(System.out::println);


        // map只能转换一次
        Flux.just(1, 2, 3, 4, 5, 6).map(a -> a * 2).subscribe(System.out::println);
        // flatMap把第一次转换的数据作为第二次的输入，可以对这个输入再操作
        Flux.just(1, 2, 3, 4, 5, 6).flatMap(a -> Flux.just(a * 2)).subscribe((a) -> System.out.println(new Person(a + 5 + "", "ff")));

        Flux.just(1, 2, 3, 4, 5, 6).handle((integer, handler) -> {
            int i = integer;
            handler.next(new Person("name" + i, "n" + i));
        }).subscribe(System.out::println);

        //testiInterval();
    }

    /**
     * Reactor的来源要么lazy，要么eager。defer号称lazy(懒)的，啥意思呢
     * <p/>
     * 有的时候，希望是lazy的状态，如Http request，被期望是用到的时候再实例化和初始化，这样可以减少资源开销，defer就适合这个场景。
     * 而像Mono.just or Flux.fromIterable就是eager的。
     * 举个例子：
     * 调用Mono.just(System.currentTimeMillis())会立刻调用执行System.currentTimeMillis()方法，计算出这个值。当调用subscribe时，
     * <font color=green size=10>mono</font>仅仅是把已经算好的值发射给subscribers，多次调用subscribe()值不会变
     * <pre>
     * Mono<Long> clock = Mono.just(System.currentTimeMillis());
     * //time == t0
     *
     * Thread.sleep(10_000);
     * //time == t10
     * clock.block(); //we use block for demonstration purposes, returns t0
     *
     * Thread.sleep(7_000);
     * //time == t17
     * clock.block(); //we re-subscribe to clock, still returns t0
     * </pre>
     * <font color=green size=10>defer</font>方法会使source成为lazy，即每次调用subscribe()都会计算lambda表达式的值
     * <pre>
     * Mono<Long> clock = Mono.defer(() -> Mono.just(System.currentTimeMillis()));
     * //time == t0
     *
     * Thread.sleep(10_000);
     * //time == t10
     * clock.block(); //invoked currentTimeMillis() here and returns t10
     *
     * Thread.sleep(7_000);
     * //time == t17
     * clock.block(); //invoke currentTimeMillis() once again here and returns t17
     * </pre>
     * 参考：https://stackoverflow.com/questions/55955567/what-does-mono-defer-do
     */
    public static void testDefer() throws InterruptedException {
        Mono<Long> clock = Mono.defer(() -> Mono.just(System.currentTimeMillis()));

        Thread.sleep(2_000);
        //invoked currentTimeMillis() here and returns t10
        System.out.println(clock.block());

        Thread.sleep(3_000);
        //invoke currentTimeMillis() once again here and returns t17
        System.out.println(clock.block());

        // 对比just结果
        System.out.println("Mono.just计算结果");

        Mono<Long> clock2 = Mono.just(System.currentTimeMillis());

        Thread.sleep(2_000);
        //we use block for demonstration purposes, returns t0
        System.out.println(clock2.block());

        Thread.sleep(3_000);
        //we re-subscribe to clock, still returns t0
        System.out.println(clock2.block());
    }

    public static void testiInterval() {
        // 间隔(周期)性的执行订阅，subscribe采用(使用新的线程)异步方式订阅
        Flux.interval(Duration.ofSeconds(1)).map(sec -> Long.toString(sec)).subscribe((a) -> System.out.println(a + " thread:" + Thread.currentThread().getName()));

        // 等待Flux.interval的执行，否则程序结束了，Flux.interval还没执行呢
        try {
            Thread.sleep(2000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testMono() {
        System.out.println("test mono start --- ");
        Mono.just(1).subscribe(System.out::println);

        Mono.just(1).single().subscribe(System.out::println);

        Mono.fromSupplier(() -> 1).subscribe(a -> System.out.println(a + " thread:" + Thread.currentThread().getName()));


        Mono.fromRunnable(() -> System.out.println("runnable")).subscribe(a -> System.out.println(a + " fromRunnable thread:" + Thread.currentThread().getName()));

        Mono.fromCallable(() -> {
            System.out.println("fromCallable:" + Thread.currentThread().getName());
            return 33;
        }).subscribe(a -> System.out.println(a + " fromCallable thread:" + Thread.currentThread().getName()));

        Mono.fromFuture(() -> {
            System.out.println("fromFuture:" + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> 2);
        }).subscribe(a -> System.out.println(a + " fromFuture thread:" + Thread.currentThread().getName()));


//        try {
//            Thread.sleep(2000 * 10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
