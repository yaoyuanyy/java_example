package com.yy.example.reactive.rxjava;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yy.example.reactive.Person;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func1;
import rx.observables.SyncOnSubscribe;

import java.util.List;
import java.util.stream.Stream;

/**
 * Description: 被观察者一旦发送有观察者订阅它，它就会把数据流发送给观察者们。(就会：不一定立刻执行)
 * <p></p>
 * <pre>
 *
 *   refer to https://faner.gitlab.io/blog/2017/08/01/RxJava-1.x-%E5%85%A5%E9%97%A8/#heading-1%E5%88%9B%E5%BB%BA-observer%E8%A7%82%E5%AF%9F%E8%80%85%E6%88%96subscriber-%E8%AE%A2%E9%98%85%E8%80%85
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-01-07 at 15:50
 */
@Slf4j
public class GetStarted {


    public static void main(String[] args) {
        //t3();
        //t3();
        //t5();
        //t6();
        t7();
    }

    // /----------------------------------------------\
    // |     observable observer subscriber三者协助    |
    // \----------------------------------------------/


    public static void t0() {
        Observable.just(1, 2).subscribe(o -> System.out.println(o));
    }

    /**
     * 创建被观察者、创建观察者、两者订阅。形式： observable.subscribe(observer)
     * 形式2：{@link #t5}
     * 形式3：{@link #t4}
     */
    public static void t1() {
        // 创建被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<Person>() {
            @Override
            public void call(Subscriber<? super Person> subscriber) {
                subscriber.onNext(Person.builder().name("aa1").build());
                subscriber.onNext(Person.builder().name("aa2").build());
                subscriber.onCompleted();
            }
        });

        // 创建观察者
        Observer<Person> observer = new Observer<Person>() {
            @Override
            public void onCompleted() {
                log.info("completed");
            }

            @Override
            public void onError(Throwable e) {
                log.error("ERROR:", e);
            }

            @Override
            public void onNext(Person p) {
                log.info("param: {}", p);
            }
        };

        // 将被观察者与观察者关联：通过订阅的方式关联
        observable.subscribe(observer);
    }

    /**
     * 被观察者、观察者、订阅写在一条语句中
     */
    public static void t2() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("String");
                subscriber.onNext("fff");
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                log.info("onCompleted-2");
            }

            @Override
            public void onError(Throwable e) {
                log.info("onError-2");
            }

            @Override
            public void onNext(String o) {
                log.info("onNext-2" + o);
            }
        });
    }

    /**
     * 出现异常时的例子
     */
    public static void t3() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("String");
                subscriber.onNext(getStr());
                subscriber.onCompleted();
                subscriber.onError(new Exception("dd"));
            }

            private String getStr() {
                throw new RuntimeException("exception");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                log.info("onCompleted-2");
            }

            @Override
            public void onError(Throwable e) {
                log.info("onError:",e);
            }

            @Override
            public void onNext(String o) {
                log.info("onNext-2" + o);
            }
        });
    }

    /**
     *
     * 订阅形式：observable.subscribe(subscriber)
     * @see #t1()
     * @see #t5()
     */
    public static void t4() {
        Person person1 = Person.builder().id(111).name("aa").build();
        Person person2 = Person.builder().id(112).name("c").build();

        //创建被观察者： 将person1、person2转化到被观察者中，被观察者会发送他们给观察者
        Observable observable = Observable.just(person1, person2);

        //创建观察者
        // 可以看到，Subscriber较Observer多了一个方法：onStart()。此方法在发射数据流之前被调用
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {
                log.info("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                log.error("onStart:{}", e);
            }

            @Override
            public void onNext(Object o) {
                log.info("onNext:{}", o);
            }

            @Override
            public void onStart() {
                log.info("onStart");
            }
        };

        // 被观察者与观察者通过订阅的方式关联上
        observable.subscribe(subscriber);

    }

    /**
     * 订阅形式：observable.subscribe(action1)
     *
     * @see #t1()
     * @see #t4()
     * @see #t6() 支持多个action入参
     * TODO 一个被观察者能给多个观察者发送事件吗
     */
    public static void t5() {
        Person person1 = Person.builder().id(111).name("aa").build();
        Person person2 = Person.builder().id(112).name("c").build();

        //创建被观察者： 将person1、person2转化到被观察者中，被观察者会发送他们给观察者
        Observable observable = Observable.just(person1, person2);

        //创建观察者
        Action1<Person> action1 = new Action1<Person>() {
            @Override
            public void call(Person p) {
                System.out.println(p.getName() + "-" +p.getId());
            }
        };

        // 被观察者与观察者通过订阅的方式关联上
        observable.subscribe(action1);

    }

    /**
     * 订阅形式：observable.subscribe(action1,action2,action3)
     * @see #t1()
     * @see #t4()
     * @see #t5()
     */
    public static void t6() {
        Observable observable = Observable.create(new Observable.OnSubscribe<Person>() {

            @Override
            public void call(Subscriber<? super Person> subscriber) {
                subscriber.onNext(Person.builder().id(6).name("t6").build());
                subscriber.onNext(getStr());
                subscriber.onCompleted();
                subscriber.onError(new Exception("dd"));
            }

            private Person getStr() {
                // when test error, open //(1)
                // return Person.builder().id(66).name("t66").build(); //(1)
                throw new RuntimeException("exception"); // (2)
            }
        });

        //创建观察者
        Action1<Person> action1 = new Action1<Person>() {
            @Override
            public void call(Person p) {
                log.info(p.getName() + "-" +p.getId());
            }
        };

        Action1<Throwable> action2 = new Action1<Throwable>() {
            @Override
            public void call(Throwable t) {
                log.error("ERROR:{} ",t);
            }
        };

        Action0 action3 = new Action0() {
            @Override
            public void call() {
                log.info("Action0:competed");
            }
        };

        // 被观察者与观察者通过订阅的方式关联上
        observable.subscribe(action1, action2, action3);
    }


    /**
     *
     */
    public static void t7() {

        Observable observable = Observable.create(SyncOnSubscribe.createStateless(new Action1<Observer<? super Person>>() {
            @Override
            public void call(Observer<? super Person> observer) {
                observer.onNext(Person.builder().name("t7").build());
                observer.onCompleted();
                observer.onError(new Exception());
            }
        }));


        //创建观察者
        Action1<Person> action1 = new Action1<Person>() {
            @Override
            public void call(Person p) {
                log.info(p.getName() + "-" +p.getId());
            }
        };

        // 被观察者与观察者通过订阅的方式关联上
        observable.subscribe(action1);
    }



    // /----------------------------------------------\
    // |        操作符map,filter,compose               |
    // \----------------------------------------------/



    /**
     * 使用map操作符转换被观察者到另一个被观察者
     * @param names
     */
    public static void t8(String... names) {

        List list = Lists.newArrayList("aa", "ee");
        Observable.from(list)
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.length();
                    }
                }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
