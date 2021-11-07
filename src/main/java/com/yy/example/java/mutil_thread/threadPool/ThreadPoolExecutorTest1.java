package com.yy.example.java.mutil_thread.threadPool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;


/**
 * 用于测试 ThreadPoolExecutor 源码，测试源码时使用3个poolExecutor.execute即可
 * 当测试拒绝策略时，打开stop(1) 和6个线程的代码，运行程序
 */
public class ThreadPoolExecutorTest1 {

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

        poolExecutor.execute(() -> {
            // stop(1);
            System.out.println("concurrent thread1-1: " + Thread.currentThread().getName());
        });

        poolExecutor.execute(() -> {
            // stop(1);
            System.out.println("concurrent thread:-2: " + Thread.currentThread().getName());
        });

        poolExecutor.shutdownNow();


        poolExecutor.execute(() -> {
            // stop(1);
            System.out.println("concurrent thread:-3: " + Thread.currentThread().getName());
        });

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
