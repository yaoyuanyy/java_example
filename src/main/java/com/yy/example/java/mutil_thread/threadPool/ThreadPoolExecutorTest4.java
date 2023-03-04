package com.yy.example.java.mutil_thread.threadPool;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * Description: Future方法的使用
 * <pre>
 *
 * </pre>
 * NB.
 * Created by skyler on 2017/11/22 at 上午10:36
 */
public class ThreadPoolExecutorTest4 {

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
            Future future = threadPoolExecutor.submit(new Runnable() {
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

            try {
                future.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            } catch (TimeoutException e) {
                System.out.println("任务执行超时");
                boolean success = future.cancel(true);
                System.out.println("任务取消结果：" + success);
            }
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
