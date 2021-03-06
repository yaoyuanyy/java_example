package com.yy.test.rxjava;

import com.yy.example.reactive.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.observables.SyncOnSubscribe;
import rx.schedulers.Schedulers;

/**
 * Description: 被观察者一旦发现有观察者订阅它，它就会把数据流发送给观察者们。(注意：不一定立刻执行)
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-01-07 at 15:50
 */
@Slf4j
public class GetStarted_1 {

    // /----------------------------------------------\
    // |     observable observer subscriber三者协助    |
    // \----------------------------------------------/

    /**
     * 创建被观察者、创建观察者、观察者订阅被观察者，也可以说被观察者通知观察者。
     * 形式： observable.subscribe(observer)
     * 形式2：{@link #t5}
     * 形式3：{@link #t4}
     */
    @Test
    public void t0() {
        // (1)创建被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<Person>() {
            @Override
            public void call(Subscriber<? super Person> subscriber) {
                subscriber.onNext(Person.builder().name("aa1").build());
                subscriber.onNext(Person.builder().name("aa2").build());
                subscriber.onCompleted();
            }
        });

        // (2)创建观察者
        Observer<Person> observer = new Observer<Person>() {
            @Override
            public void onNext(Person p) {
                log.info("param: {}", p);
            }

            @Override
            public void onCompleted() {
                log.info("completed");
            }

            @Override
            public void onError(Throwable e) {
                log.error("ERROR:", e);
            }
        };

        // (3)将被观察者与观察者关联：观察者通过订阅被观察者的方式关联
        observable.subscribe(observer);
    }

    /**
     * 被观察者、观察者、订阅写在一条语句中
     */
    @Test
    public void t1() {
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
    @Test
    public void t2() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext("String");
                    subscriber.onNext(getStr());
                    subscriber.onCompleted();
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(new Exception("dd"));
                }
            }

            private String getStr() {
                throw new RuntimeException("exception");
            }


        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                log.info("onCompleted-2:");
            }

            @Override
            public void onError(Throwable e) {
                log.info("onError:", e);
            }

            @Override
            public void onNext(String o) {
                log.info("onNext-2:" + o);
            }
        });
    }

    /**
     * 创建被观察者、创建观察者、观察者订阅被观察者，也可以说被观察者通知观察者。
     * 形式： observable.subscribe(Action)
     * 形式2：{@link #t0}
     */
    @Test
    public void t2_2() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("String");
                subscriber.onNext("String2");
            }

        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                log.info("action1 result:{}",s);
            }
        });
    }


    /**
     * Observable observable = Observable.just("Hello", "Hi", "Aloha");
     * // 将会依次调用：
     * // onNext("Hello");
     * // onNext("Hi");
     * // onNext("Aloha");
     * // onCompleted();
     */
    @Test
    public void t3() {
        Observable.just(1, 2).subscribe(o -> System.out.println(o));
    }

    /**
     * 订阅形式：observable.subscribe(subscriber)
     * subscriber较observer多了一个onStart()方法
     *
     * @see #t1()
     * @see #t5()
     */
    @Test
    public void t4() {
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
                log.error("onError:{}", e);
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
     * @see #t0()
     * @see #t4()
     * @see #t6() 支持多个action入参
     * TODO 一个被观察者能给多个观察者发送事件吗
     */
    @Test
    public void t5() {
        Person person1 = Person.builder().id(111).name("aa").build();
        Person person2 = Person.builder().id(112).name("c").build();

        //创建被观察者： 将person1、person2转化到被观察者中，被观察者会发送他们给观察者
        Observable observable = Observable.just(person1, person2);

        //创建观察者
        Action1<Person> action1 = new Action1<Person>() {
            @Override
            public void call(Person p) {
                System.out.println(p.getName() + "-" + p.getId());
            }
        };

        // 被观察者与观察者通过订阅的方式关联上
        observable.subscribe(action1);

    }

    /**
     * 订阅形式：observable.subscribe(action1,action2,action3)
     *
     * @see #t0()
     * @see #t4()
     * @see #t5()
     */
    @Test
    public void t6() {
        Observable observable = Observable.create(new Observable.OnSubscribe<Person>() {

            @Override
            public void call(Subscriber<? super Person> subscriber) {
                subscriber.onNext(Person.builder().id(6).name("t6").build());
                subscriber.onNext(getStr());
                subscriber.onCompleted();
            }

            private Person getStr() {
                // when test error, open (1) close (2)
                //return Person.builder().id(66).name("t66").build(); //(1)
                throw new RuntimeException("exception"); // (2)
            }
        });

        //创建观察者
        Action1<Person> action1 = new Action1<Person>() {
            @Override
            public void call(Person p) {
                log.info(p.getName() + "-" + p.getId());
            }
        };

        Action1<Throwable> action2 = new Action1<Throwable>() {
            @Override
            public void call(Throwable t) {
                log.error("ERROR:{} ", t);
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
     * Observable.create(new Observable.OnSubscribe()已被Deprecated，使用Observable.create(SyncOnSubscribe.createStateless()代替
     */
    @Test
    public void t7() {
        Observable observable = Observable.create(SyncOnSubscribe.createStateless(new Action1<Observer<? super Person>>() {
            @Override
            public void call(Observer<? super Person> observer) {
                observer.onNext(Person.builder().name("t7").build());
                observer.onCompleted();
                // 这句放这是错误的，因为程序走了observer.onCompleted()方法后，就不会执行observer.onError()方法
                // 正确的使用方法见this.t8()会this.t2()方法
                // observer.onError(new Exception());
            }
        }));


        //创建观察者
        Action1<Person> action1 = new Action1<Person>() {
            @Override
            public void call(Person p) {
                log.info(p.getName() + "-" + p.getId());
            }
        };

        // 被观察者与观察者通过订阅的方式关联上
        observable.subscribe(action1);
    }

    /**
     * SyncOnSubscribe.createSingleState()多参数结合subscribeOn()例子
     * <p>
     * Observable.create(SyncOnSubscribe.createSingleState(Func0<? extends S> generator,
     * final Action2<? super S, ? super Observer<? super T>> next,
     * final Action1<? super S> onUnsubscribe)
     * <p>
     * <p>
     * <p>
     * TODO Observable.subscribeOn() Observable.observeOn()作用、使用、效果见GetStarted_4 class
     */
    @Test
    public void t8() {
        Observable observable2 = Observable.create(SyncOnSubscribe.createSingleState(new Func0<String>() {
                @Override
                public String call() {
                    System.out.println("Func0 cur thread:" + Thread.currentThread().getName());
                    return "t7";
                }
            }, new Action2<String, Observer<? super Person>>() {

                @Override
                public void call(String s, Observer<? super Person> observer) {
                    try {
                        System.out.println(s + " Action2 cur thread:" + Thread.currentThread().getName());
                        observer.onNext(Person.builder().name(s).build());
                        observer.onCompleted();

                    } catch (Exception e) {
                        e.printStackTrace();
                        observer.onError(e);
                    }
                }
            }, (a) -> {
                System.out.println(a + " lambda cur thread:" + Thread.currentThread().getName());
            })
        ).subscribeOn(Schedulers.io());


        observable2.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println(o);
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


