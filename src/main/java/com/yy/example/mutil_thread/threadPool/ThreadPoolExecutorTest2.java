package com.yy.example.mutil_thread.threadPool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest2 {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new DefaultThreadFactory("ThreadPoolExecutorTest2 --> %d"),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("RejectedExecutionHandler" + r.toString() + " executor:" + executor.getPoolSize());
                    }
                }
            );

        poolExecutor.execute(() -> {
            System.out.println("concurrent thread1-1:" + Thread.currentThread().getName());
        });

        poolExecutor.execute(() -> {
            System.out.println("concurrent thread:-2" + Thread.currentThread().getName());
        });

        poolExecutor.execute(() -> {
            System.out.println("concurrent thread:-3" + Thread.currentThread().getName());
        });

        poolExecutor.execute(() -> {
            System.out.println("concurrent thread:-4" + Thread.currentThread().getName());
        });

        poolExecutor.execute(() -> {
            System.out.println("concurrent thread:-5" + Thread.currentThread().getName());
        });

        poolExecutor.execute(() -> {
            System.out.println("concurrent thread:-6" + Thread.currentThread().getName());
        });
    }
}
