package com.yy.test.rxjava;

import com.google.common.collect.Lists;
import com.yy.example.reactive.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.*;
import rx.observables.SyncOnSubscribe;
import rx.schedulers.Schedulers;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Description: rxjava操作符实战
 * <pre>
 * 简单来说：操作符就是Observable的各种操作，例如：创建，变换，过滤操作等等。在这里需要强调下的是，Observable通过操作符的操作之后会得到一个新的Observable，每创建一个操作符，简单来说就是创建了一个子任务。
 *
 * 操作符让你可以变换、组合、操纵和处理Observable发射的数据。
 *
 * 操作符可以分为多种类型：
 *  创建操作：用于创建Observable的操作符
 *  变换操作：这些操作符可用于对Observable发射的数据进行变换
 *  过滤操作：这些操作符用于从Observable发射的数据中进行选择
 *  组合操作：组合操作符用于将多个Observable组合成一个单一的Observable
 *  错误处理：这些操作符用于从错误通知中恢复
 *  辅助操作：一组用于处理Observable的操作符
 *  条件和布尔操作：这些操作符可用于单个或多个数据项,也可用于Observable
 *  算术和聚合操作：这些操作符可用于整个数据序列
 *  连接操作：一些有精确可控的订阅行为的特殊Observable
 *  转换操作
 *
 *
 * 几种主要的需求：
 *  直接创建一个Observable(创建操作)
 *  组合多个Observable(组合操作)
 *  对Observable发射的数据执行变换操作(变换操作)
 *  从Observable发射的数据中取特定的值(过滤操作)
 *  转发Observable的部分值(条件/布尔/过滤操作)
 *  对Observable发射的数据序列求值(算术/聚合操作)
 * </pre>
 * <pre>
 *
 *   refer to https://juejin.im/entry/59e406c9f265da43215315b9
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-01-07 at 15:50
 */
@Slf4j
public class GetStarted_2 {

    // /---------------------------------------------------------\
    // |        创建操作符: create,just,from,defer,lift            |
    // \---------------------------------------------------------/

    /**
     * just操作符：将对象或者对象集合转换为一个能够发射这些对象的Observable
     * <p>
     * NB. 内部实际调用的是from方法
     *
     * @see #t2()
     */
    @Test
    public void t0() {
        Observable.just("1", 2)
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        System.out.println(o);
                    }
                });
    }

    /**
     * from操作符: 将其它的对象或数据结构转换为Observable
     */
    @Test
    public void t1() {

        List list = Lists.newArrayList("aa", "ee");
        Observable.from(list)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }

    /**
     * Observable.from(future)的例子
     */
    @Test
    public void t1_1() {

        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(1000 * 5);
            log.info("t5 future cur thread:{}", Thread.currentThread().getName());
            return "dd";
        });

        Observable.from(future).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                log.info("t5 value:{} cur thread:{}", s, Thread.currentThread().getName());
            }
        });
    }

    // /----------------------------------------------\
    // |        变换操作符: map,flatMap,lift           |
    // \----------------------------------------------/

    /**
     * Observable.map()：转换操作符
     * <p>
     * map操作符：一对一变换。一个对象 -> 另一个对象 或者 一个数组 -> 另一个数组。
     * <p>
     * Map操作符对原始Observable发射的每一项数据都应用一次你选择的函数，执行变换操作，然后返回一个发射这些结果的Observable
     *
     * @see #t3() flatMap() 和 map()比较
     */
    @Test
    public void t2() {
        // 正常编写
        List<Person> list = Lists.newArrayList(Person.builder().name("a").id(1).build(), Person.builder().name("b").id(2).build());
        Observable.from(list)
                .map(new Func1<Person, Integer>() {
                    @Override
                    public Integer call(Person p) {
                        log.info("func1 thread:{}", Thread.currentThread().getName());
                        return p.getId();
                    }
                }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                log.info("func1 thread:{}", Thread.currentThread().getName());
                System.out.println(integer);
            }
        });

    }

    /**
     * 与{@link GetStarted_2#t2()}的区别是采用lambda编写
     *
     * @see GetStarted_2#t2()
     */
    @Test
    public void t2_2() {
        List<Person> list = Lists.newArrayList(Person.builder().name("a").id(1).build(), Person.builder().name("b").id(2).build());

        // 采用lambda编写
        Observable.from(list).map((a) -> a.getName()).subscribe(b -> System.out.println(b));
    }


    /**
     * Observable.flatMap()：转换操作符
     * <p>
     * flatMap操作符: 将Observable发射的数据变换为Observables集合,然后将这些Observable发射的数据平坦化的放进一个单独的Observable,可以认为是一个将嵌套的数据结构展开的过程
     *
     * <pre>
     *   FlatMap操作符使用一个指定的函数对原始Observable发射的每一项数据执行变换操作，这个函数返回一个本身也发射数据的Observable，然后FlatMap合并这些Observables发射的数据，最后将合并后的结果当做它自己的数据序列发射。
     *   这个方法是很有用的，例如，当你有一个这样的Observable：它发射一个数据序列，这些数据本身包含Observable成员或者可以变换为Observable，因此你可以创建一个新的Observable发射这些次级Observable发射的数据的完整集合。
     * </pre>
     *
     * <pre>
     * NB. FlatMap对这些Observables发射的数据做的是合并(merge)操作，因此它们可能是交错的。（这句话说的不明不白，这里的merge类似与 git中的merge吗？）如果需要按顺序连接可以使用 concatMap 操作符。
     *
     * NB. 如果任何一个通过这个flatMap操作产生的单独的Observable(新Observable)调用onError异常终止了，这个Observable(旧Observable)自身会立即调用onError并终止。
     * </pre>
     * <p>
     * flatMap() 和 map()比较
     * <p>
     * flatMap() 和 map() 有一个相同点：它也是把传入的参数转化之后返回另一个对象。但需要注意，和 map()不同的是， flatMap() 中返回的是个 Observable 对象，并且这个 Observable 对象并不是被直接发送到了 Subscriber 的回调方法中。
     * flatMap() 的原理是这样的：
     * 1. 使用传入的事件对象创建一个 Observable 对象；
     * 2. 并不发送这个 Observable, 而是将它激活，于是它开始发送事件；
     * 3. 每一个创建出来的 Observable 发送的事件，都被汇入同一个 Observable ，而这个 Observable 负责将这些事件统一交给 Subscriber 的回调方法。
     * </p>
     */
    @Test
    public void t3() {
        List<Person> list = Lists.newArrayList(Person.builder().name("a").id(1).build(), Person.builder().name("b").id(2).build());

        Observable.from(list)
                .flatMap(new Func1<Person, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(Person person) {
                        return Observable.just(person.getId(), 3);
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                log.info("completed");
            }

            @Override
            public void onError(Throwable e) {
                log.error("onError:{}", e);
            }

            @Override
            public void onNext(Integer i) {
                log.info("onNext:{}", i);
            }
        });

    }

    /**
     * 与{@link GetStarted_2#t3()}的区别是采用lambda编写
     *
     * @see GetStarted_2#t3()
     */
    @Test
    public void t3_2() {
        List<Person> list = Lists.newArrayList(Person.builder().name("a").id(1).build(), Person.builder().name("b").id(2).build());

        Observable.from(list)
                .flatMap(a -> Observable.from(Lists.newArrayList(a.getId(), "prefix")))
                .subscribe(b -> log.info("result:{}", b));
    }

    /**
     * Observable.lift()：转换操作符
     * <pre>
     *         Observable observable1 = Observable.just("images/logo.png"); // 输入类型 String
     *
     *         Observable observable2 = observable1.map(new Func1&lt;String, Bitmap&gt;() {
     *                    {@literal @}Override
     *                     public Bitmap call(String filePath) { // 参数类型 String
     *                         return getBitmapFromPath(filePath); // 返回类型 Bitmap
     *                     }
     *                 }
     *         );
     *
     *         observable2.subscribe(new Action1&lt;Bitmap&gt;() {
     *                    {@literal @}Override
     *                     public void call(Bitmap bitmap) { // 参数类型 Bitmap
     *                         showBitmap(bitmap);
     *                     }
     *                 }
     *         );
     *
     *  observable2里的OnSubscribe对象的call方法会被调用。而observable2就是lift方法返回的Observable对象， observable2里的onSubscribe对象就是lift的核心重点
     *
     *  observable2对象里面通过observable1对象的onSubscribe.call(newSubscriber)达到通知observable1目的。
     *  因为observable1对象是我们初始的Observable对象，它的onSubscribe.call会发送事件到newSubscriber。
     *  newSubscriber是operator.call(subscriber)返回的，newSubscriber做了两件事：
     *  1.进行事件的变换操作。newSubscriber能拿到初始的事件，可以进行转换操作，这也是操作符发生效力的地方，不同的操作符的作用就是对事件进行不同的转换。
     *  2.转发给subscriber，newSubscriber有subscriber的引用，可以将转换后的事件转发给subscriber，也就是最终的订阅者。
     *
     *  <B>lift方法返回的observable2对象在调用链的中间起到了一个中转的作用，这就是lift原理的核心。</B>
     *
     *  链接：https://www.jianshu.com/p/b15d9b3e194e
     * </pre>
     * <p>
     * 本例子是将Integer类型数据转换成Person类型数据
     */
    @Test
    public void t4() {
        Observable.just(1, 2).lift(new Observable.Operator<Person, Integer>() {
            @Override
            public Subscriber<? super Integer> call(Subscriber<? super Person> subscriber) {
                return new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        log.info("lift Subscriber completed");
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        log.error("lift onError throw:{}", e);
                        subscriber.onError(e);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info("lift Subscriber onNext value:{}", integer);
                        subscriber.onNext(Person.builder().id(integer).build());
                    }
                };
            }
        }).subscribe(new Subscriber<Person>() {
            @Override
            public void onCompleted() {
                log.info("outer onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                log.info("outer onError value:{}", e);

            }

            @Override
            public void onNext(Person person) {
                log.info("outer subscribe value:{}", person);
            }
        });
    }


    // /---------------------------------------------------------\
    // |  下列操作符一般用于测试: never,empty,error        |
    // \---------------------------------------------------------/


    @Test
    public void t6() {

        // 不发送任何Items和通知给observer
        Observable.never().single().subscribe(a -> log.info("never():{}", a));

        // 不发送任何Items，但是会立刻调用OnCompleted
        Observable.empty().subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {
                log.info("empty() onCompleted被empty调用到了");
            }

            @Override
            public void onError(Throwable e) {
                log.info("empty() onError被empty调用到了");
            }

            @Override
            public void onNext(Object o) {
                log.info("empty() onNext被empty调用到了");
            }
        });

        // 会立刻调用onError
        Observable.error(new RuntimeException("dd")).subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {
                log.info("error() onCompleted被error调用到了");
            }

            @Override
            public void onError(Throwable e) {
                log.info("error() onError被error调用到了 ERROR:{}", e);
            }

            @Override
            public void onNext(Object o) {
                log.info("error() onNext被error调用到了 value:{}", o);
            }
        });
    }


    // /---------------------------------------------------------\
    // |  下列操作符一般用于测试: defer及实际使用        |
    // \---------------------------------------------------------/


    /**
     * 本例演示Observable.defer()的效果，为了对比，使用Observable.just()形成对比。结合{@link GetStarted_2#t9_2()}看效果
     */
    @Test
    public void t9_1() {
        SomeType someType = new SomeType();
        Observable<String> observable1 = someType.init_just();
        someType.setValue("dd");
        observable1.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                log.info("t9 just value:{}", s);
            }
        });
    }

    /**
     * <pre>
     *  本例演示Observable.defer()的效果
     *  参考：https://www.jianshu.com/p/c83996149f5b
     * </pre>
     * 结合{@link GetStarted_2#t9_1()}看效果
     */
    @Test
    public void t9_2() {
        SomeType someType = new SomeType();
        Observable<String> observable = someType.init_defer();
        someType.setValue("dd");
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                log.info("t9 defer value:{}", s);
            }
        });
    }

}

class SomeType {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public Observable<String> init_just() {
        return Observable.just(value);
    }

    public Observable<String> init_defer() {
        return Observable.<String>defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(value);
            }
        });
    }
}
