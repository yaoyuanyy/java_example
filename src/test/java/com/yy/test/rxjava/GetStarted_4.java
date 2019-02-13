package com.yy.test.rxjava;

import com.yy.example.reactive.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Notification;
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
 * Description: Observable结合Observable.doOnXXX()方法实战
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-01-07 at 15:50
 */
@Slf4j
public class GetStarted_4 {

    // /----------------------------------------------\
    // |     Observable.doOnXXX()方法实战              |
    // \----------------------------------------------/

    /**
     * doOnNext例子
     */
    @Test
    public void t0() {
        Observable.just(1, 2).doOnNext(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                log.info("doOnNext value:{}", integer);
            }
        }).subscribe(o -> log.info("subscribe value:{}", o));
    }

    /**
     * doOnSubscribe例子
     *
     * <pre>
     *
     *     在前面讲 Subscriber 的时候，提到过 Subscriber 的 onStart() 可以用作流程开始前的初始化。
     *     然而 onStart() 由于在 subscribe()发生时就被调用了，因此不能指定线程，而是只能执行在 subscribe() 被调用时的线程。
     *     这就导致如果 onStart() 中含有对线程有要求的代码（例如在界面上显示一个 ProgressBar，这必须在主线程执行），将会有线程非法的风险，因为有时你无法预测 subscribe() 将会在什么线程执行。
     *
     *     而与 Subscriber.onStart() 相对应的，有一个方法 Observable.doOnSubscribe()。它和 Subscriber.onStart() 同样是在 subscribe() 调用后而且在事件发送前执行，但区别在于它可以指定线程。
     *     默认情况下， doOnSubscribe() 执行在 subscribe() 发生的线程；而如果在 doOnSubscribe() 之后有 subscribeOn() 的话，它将执行在离它最近的 subscribeOn() 所指定的线程
     * </pre>
     */
    @Test
    public void t1() {
        Observable.just(1, 2)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        log.info("doOnSubscribe call value");
                    }
                }).subscribe(o -> log.info("subscribe value:{}", o));
    }



    /**
     * Observable.create(new Observable.OnSubscribe()已被Deprecated，使用Observable.create(SyncOnSubscribe.createStateless()代替
     */
    @Test
    public void t7() {
        Observable observable = Observable.create(SyncOnSubscribe.createStateless(new Action1<Observer<? super Person>>() {
            @Override
            public void call(Observer<? super Person> observer) {
                try {
                    observer.onNext(Person.builder().name("t7").build());
                    observer.onCompleted();
                } catch (Exception e) {
                    e.printStackTrace();
                    observer.onError(new Exception());
                }
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


    @Test
    public void t9() {
        Observable observable2 = Observable.create(SyncOnSubscribe.createSingleState(
            new Func0<String>() {
                @Override
                public String call() {
                    log.info("createSingleState param 1, cur thread:{}", Thread.currentThread().getName());
                    return "t7";
                }
            }, new Action2<String, Observer<? super Person>>() {
                @Override
                public void call(String s, Observer<? super Person> observer) {
                    try {
                        log.info("createSingleState param 2 value:{}, cur thread:{}", s, Thread.currentThread().getName());
                        observer.onNext(Person.builder().name(s).build());
                        observer.onCompleted();

                    } catch (Exception e) {
                        e.printStackTrace();
                        observer.onError(e);
                    }
                }
            }, (a) -> {
                log.info("createSingleState param 3 value:{}, cur thread:{}", a, Thread.currentThread().getName());
            })
        );


        observable2.doOnNext(new Action1() {
            @Override
            public void call(Object o) {
                log.info("doOnNext 调用onNext后走这里代码 value:{}, cur thread:{}", o, Thread.currentThread().getName());
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                log.info("doOnTerminate 代码执行完走这里，cur thread:{}", Thread.currentThread().getName());
            }
        }).doOnEach(new Action1<Notification>() {
            @Override
            public void call(Notification notification) {
                log.info("doOnEach 代码执行完走这里，cur thread:{}", Thread.currentThread().getName());
            }
        }).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                log.info("subscribe，value:{} cur thread:{}", o, Thread.currentThread().getName());
            }
        });
    }

}
