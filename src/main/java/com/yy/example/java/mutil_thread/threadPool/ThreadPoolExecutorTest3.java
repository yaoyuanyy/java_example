package com.yy.example.java.mutil_thread.threadPool;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: 测试ThreadPoolExecutor shutdown  termnated 方法，线程池状态是如何变化的
 * <pre>
 *
 * </pre>
 * NB.
 * Created by skyler on 2017/11/22 at 上午10:36
 */
public class ThreadPoolExecutorTest3 {

    public static void main(final String[] args) {

        final ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 10, 60 * 10, TimeUnit.SECONDS,
                        new LinkedBlockingDeque(5),
                        new BasicThreadFactory.Builder().namingPattern("test-thread-pool-%d").build(),
                        new RejectedExecutionHandler() {
                            @Override
                            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                                System.out.println("rejectedExecution");
                            }
                        }
                );

        for (int i = 1; i <= 16; i++) {
            final int task = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " for task of " + task);
                }
            });
        }

        try {
            Thread.sleep(1000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
//        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();

        try {
            threadPoolExecutor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
