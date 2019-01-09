package com.yy.test.rxjava;

import com.google.common.collect.Lists;
import com.yy.example.reactive.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.io.Serializable;
import java.util.List;

/**
 * Description: rxjava异步执行
 * <p></p>
 * <pre>
 *
 *   NB.
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
     * just操作符：将对象或者对象集合转换为一个能够发射这些对象的Observable
     *
     * NB. 与from操作符的区别
     * @see #t2()
     */
    @Test
    public void t0(){
        Observable.just("1",2)
                //.subscribeOn(Schedulers.io()) //TODO 加上这句后无法打印出结果
            .subscribe(new Action1<Serializable>() {
                @Override
                public void call(Serializable serializable) {
                    log.info("Action1 thread:{}", Thread.currentThread().getName());
                    System.out.println(serializable);
                }
        });
    }

    /**
     * from操作符: 将其它的对象或数据结构转换为Observable
     *
     * NB. 与just操作符的区别: from类似于Just，但是from会将数组或Iterable的数据取出然后逐个发射，而Just只是简单的原样发射，将数组或Iterable当做单个数据
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

    // /----------------------------------------------\
    // |        变换操作符: map,flatMap                |
    // \----------------------------------------------/

    /**
     * map操作符：一对一变换。一个对象 -> 另一个对象 或者 一个数组 -> 另一个数组。
     *
     * Map操作符对原始Observable发射的每一项数据都应用一次你选择的函数，执行变换操作，然后返回一个发射这些结果的Observable
     *
     * @see #t3() flatMap() 和 map()比较
     */
    @Test
    public void t2() {
        // 正常编写
        List<Person> list = Lists.newArrayList(Person.builder().name("a").id(1).build(), Person.builder().name("cb").id(3).build());
        Observable.from(list)
            .map(new Func1<Person, Integer>() {
                @Override
                public Integer call(Person p) {
                    log.info("func1 thread:{}", Thread.currentThread().getName());
                    return p.getId();
                }
            }).subscribeOn(Schedulers.io())
              .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        log.info("func1-2 thread:{} result:{}", Thread.currentThread().getName(),integer);
                        return integer+3;
                    }
                })
              .observeOn(Schedulers.newThread())
              .subscribe(new Action1<Integer>() {
                @Override
                public void call(Integer integer) {
                    log.info("Action1 thread:{} result:{}", Thread.currentThread().getName(), integer);
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
     * flatMap操作符: 将Observable发射的数据变换为Observables集合,然后将这些Observable发射的数据平坦化的放进一个单独的Observable,可以认为是一个将嵌套的数据结构展开的过程
     *
     * <pre>
     *   FlatMap操作符使用一个指定的函数对原始Observable发射的每一项数据执行变换操作，这个函数返回一个本身也发射数据的Observable，然后FlatMap合并这些Observables发射的数据，最后将合并后的结果当做它自己的数据序列发射。
     *
     * 这个方法是很有用的，例如，当你有一个这样的Observable：它发射一个数据序列，这些数据本身包含Observable成员或者可以变换为Observable，因此你可以创建一个新的Observable发射这些次级Observable发射的数据的完整集合。
     * </pre>
     *
     * <pre>
     * NB. FlatMap对这些Observables发射的数据做的是合并(merge)操作，因此它们可能是交错的。（这句话说的不明不白，这里的merge类似与 git中的merge吗？）如果需要按顺序连接可以使用 concatMap 操作符。
     *
     * NB. 如果任何一个通过这个flatMap操作产生的单独的Observable(新Observable)调用onError异常终止了，这个Observable(旧Observable)自身会立即调用onError并终止。
     * </pre>
     *
     * flatMap() 和 map()比较
     * <p>
     *     flatMap() 和 map() 有一个相同点：它也是把传入的参数转化之后返回另一个对象。但需要注意，和 map()不同的是， flatMap() 中返回的是个 Observable 对象，并且这个 Observable 对象并不是被直接发送到了 Subscriber 的回调方法中。 flatMap() 的原理是这样的：1. 使用传入的事件对象创建一个 Observable 对象；2. 并不发送这个 Observable, 而是将它激活，于是它开始发送事件；3. 每一个创建出来的 Observable 发送的事件，都被汇入同一个 Observable ，而这个 Observable 负责将这些事件统一交给 Subscriber 的回调方法。
     * </p>
     */
    @Test
    public void t3(){
        List<Person> list = Lists.newArrayList(Person.builder().name("a").id(1).build(), Person.builder().name("b").id(2).build());

        Observable.from(list)
                .flatMap(a -> Observable.from(Lists.newArrayList(a.getId(), "prefix")))
                .subscribe(b -> log.info("result:{}",b));

        Observable.from(list)
                .flatMap(a -> Observable.from(Lists.newArrayList(a.getId(), 3)))
                .subscribe(new Observer<Integer>() {
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

        //Observable.just(1).
    }
}
