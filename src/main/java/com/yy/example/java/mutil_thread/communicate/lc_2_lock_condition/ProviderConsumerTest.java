package com.yy.example.java.mutil_thread.communicate.lc_2_lock_condition;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <pre>
 *
 * https://biteeniu.github.io/java/how-to-use-wait-notify-notifyall/
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/17 at 08:15
 */
public class ProviderConsumerTest {

    static Lock lock = new ReentrantLock();
    static Condition full = lock.newCondition();
    static Condition empty = lock.newCondition();


    public static void main(String[] args) {
        System.out.println("使用ReentrantLock Condition 实现生产者消费者");
        List<String> list = new LinkedList<>();

        /** 生产者一个线程，消费者一个线程 */
//        Thread p = new Thread(new Provider(list, 3, lock, full, empty));
//        Thread c = new Thread(new Consumer(list, lock, full, empty));
//
//        p.start();
//        c.start();


        /** 生产者多个线程，消费者多个线程 */
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new Provider(list, 3, lock, full, empty));
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer(list, lock, full, empty));
        }

        try {
            Thread.sleep(1000*1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


