package com.yy.example.java.mutil_thread.threadPool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 用于测试线程池运行过程中线程中断的场景
 */
public class ThreadPoolExecutorTest1_1 {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new DefaultThreadFactory("ThreadPool -- source test --> %d"),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("RejectedExecutionHandler " + r.toString() + " executor:" + executor.getPoolSize());
                    }
                }
            );

        poolExecutor.allowCoreThreadTimeOut(true);

        Thread t1 = new Thread(() -> {
            // stop(1);
            System.out.println("concurrent thread1-1: " + Thread.currentThread().getName());
        });
        poolExecutor.execute(t1);

        Thread t2 = new Thread(() -> {
            // stop(1);
            System.out.println("concurrent thread:-2: " + Thread.currentThread().getName());
        });
        poolExecutor.execute(t2);

        // t1.interrupt(); // 无用 当任务(一个线程)被线程池中的一个线程执行过程中，这个任务线程是不接收中断的

        poolExecutor.shutdownNow();

        Thread t3 = new Thread(() -> {
            // stop(1);
            System.out.println("concurrent thread:-3: " + Thread.currentThread().getName());
        });
        poolExecutor.execute(t3);


//        poolExecutor.execute(() -> {
//            // stop(1);
//            System.out.println("concurrent thread:-4:" + Thread.currentThread().getName());
//        });

//        poolExecutor.execute(() -> {
//            stop(1);
//            System.out.println("concurrent thread:-5:" + Thread.currentThread().getName());
//        });
//
//        poolExecutor.execute(() -> {
//            stop(1);
//            System.out.println("concurrent thread:-6:" + Thread.currentThread().getName());
//        });

    }

    private static void stop(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
