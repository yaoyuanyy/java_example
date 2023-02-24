package com.yy.example.java.mutil_thread.communicate.lc_3_blocking_queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:
 * <pre>
 *
 * https://biteeniu.github.io/java/how-to-use-wait-notify-notifyall/
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/17 at 08:15
 */
public class ProviderConsumerTest {

    public static void main(String[] args) {
        System.out.println("使用LinkedBlockingQueue 实现生产者消费者");

        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);

        /** 生产者一个线程，消费者一个线程 */
        Thread p = new Thread(new Provider(blockingQueue));
        Thread c = new Thread(new Consumer(blockingQueue));

        p.start();
        c.start();


//        /** 生产者多个线程，消费者多个线程 */
//        ExecutorService service = Executors.newFixedThreadPool(15);
//        for (int i = 0; i < 5; i++) {
//            service.submit(new Provider(blockingQueue));
//        }
//        for (int i = 0; i < 10; i++) {
//            service.submit(new Consumer(blockingQueue));
//        }
//
//        try {
//            Thread.sleep(1000 * 1000 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}


