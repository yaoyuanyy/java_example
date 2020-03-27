package com.yy.example.reactive.rxjava;

import com.yy.example.reactive.Person;
import lombok.extern.slf4j.Slf4j;
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
public class GetStarted_0 {


    public static void main(String[] args) {
        /**
         * 本class为入门索引，具体实战例子参见测试用例：
         */
    }

    // /----------------------------------------------\
    // |     observable observer subscriber三者协助    |
    // \----------------------------------------------/


    // /----------------------------------------------\
    // |        操作符map,filter,compose               |
    // \----------------------------------------------/

}
