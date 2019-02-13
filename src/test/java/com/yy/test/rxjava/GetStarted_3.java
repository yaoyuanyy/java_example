package com.yy.test.rxjava;

import com.yy.example.reactive.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Description: rxjava异步执行
 * <pre>
 *
 * Observable(可观察对象)提供了两个方法来设置调度器：
 *   subscribeOn()：指定 subscribe() 所发生的线程，即 Observable.OnSubscribe 被激活时所处的线程。或者叫做事件产生的线程。
 *   observeOn(): 指定 Subscriber 所在的线程。或者叫做事件消费的线程。(这样更好理解)
 *
 * 另一种解释(恕我愚昧，这两种解释到底有没有区别?)：
 *   subscribeOn(): 它指示Observable将全部的处理过程(包括发射数据和通知)放在特定的调度器上执行。事件产生的线程。
 *   observeOn(): 指定 Observable 在一个特定的调度器上调用 Observe(观察者)的相关方法。由上文可知是在 Observable.OnSubscribe<T>的call()方法中调用Observe(观察者)的相关方法，那么这里说明的就是该 call() 方法中的onNext、onError和onCompleted执行时所在的调度器(那么调用call()方法的这个语句是在哪个线程？并且看起来是只有call方法中的上述三条语句在observeOn()指定的线程上运行)。事件消费的线程。
 *
 * 根据打印出的Log来看：
 *   subscribeOn()：指定OnSubscribe.call()的执行线程，即Observable通知Subscriber的线程；
 *   observeOn()：指定Subscriber回调(onNext、onError和onCompleted)的执行线程。
 *
 * 或者直接这样更好理解：
 *   subscribeOn(): 它指示Observable对象执行时所在的线程
 *   observeOn(): 指定 Observe或Subscriber 对象执行时所在的线程。
 * </pre>
 * <pre>
 *   总结：
 *    1. subscribeOn()执行Observable.OnSubscribe.call()方法的代码，并且一直使用这个线程去处理后面的代码，直到遇到observeOn();
 *    2. 一旦有observeOn()，它后面的代码执行都会使用它的线程
 *    3. observeOn() 指定的是它之后的操作符所在的线程。操作符可以有多个，那么observeOn() 也可以调用多次。
 *    4. 不同于observeOn()，subscribeOn()的位置放在哪里都可以，但它是只能调用一次的。当使用了多个subscribeOn()的时候，只有第一个subscribeOn()起作用。
 *
 *   https://faner.gitlab.io/blog/2017/08/01/RxJava-1.x-入门/#heading-1创建-observer观察者或subscriber-订阅者
 * </pre>
 * <p>
 * Created by skyler on 2019-01-07 at 15:50
 */
@Slf4j
public class GetStarted_3 {

    // /----------------------------------------------------\
    // |        异步执行: subscribeOn observeOn Schedulers    |
    // \----------------------------------------------------/


    /**
     * 只有observeOn()方法，且在map()后
     */
    @Test
    public void t0() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        })
                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                })
                .observeOn(Schedulers.newThread())
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person p2) {
                        log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
                    }
                });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 只有observeOn()方法，且在map()前
     */
    @Test
    public void t0_2() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        }).observeOn(Schedulers.newThread())
                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                })

                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person p2) {
                        log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
                    }
                });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 只有subscribeOn()方法，且在map()前
     */
    @Test
    public void t1() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        }).subscribeOn(Schedulers.io())
                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                })

                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person p2) {
                        log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
                    }
                });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 只有subscribeOn()方法，且在map()后
     */
    @Test
    public void t1_2() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        })
                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person p2) {
                        log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
                    }
                });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // /---------------------------------------------------------\
    // |        subscribeOn()与observeOn()都存在                   |
    // \---------------------------------------------------------/


    @Test
    public void t2() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        }).subscribeOn(Schedulers.io())
                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                })
                .observeOn(Schedulers.newThread())
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person p2) {
                        log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
                    }
                });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2_2() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                }).subscribe(new Action1<Person>() {
            @Override
            public void call(Person p2) {
                log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
            }
        });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2_3() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        })
                .observeOn(Schedulers.newThread())
                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person p2) {
                        log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
                    }
                });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2_4() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        })

                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                })
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person p2) {
                        log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
                    }
                });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2_5() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.info("OnSubscribe cur thread:{}", Thread.currentThread().getName());
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        })

                .map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        log.info("map() cur thread:{}", Thread.currentThread().getName());
                        return Person.builder().name(s).build();
                    }
                })

                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person p2) {
                        log.info("action1 result:{} cur thread:{}", p2, Thread.currentThread().getName());
                    }
                });

        // 等待其他线程执行完
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
