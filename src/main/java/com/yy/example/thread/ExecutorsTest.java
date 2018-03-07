package com.yy.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/23 at 下午3:46
 */
public class ExecutorsTest {

    public static void main(final String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(4);
        executeTask(service);


        final ExecutorService service1 = Executors.newCachedThreadPool();
        executeTask(service1);

    }

    private static void executeTask(final ExecutorService service) {
        for (int i = 1; i <= 10; i++) {
            final int task = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "  for task of " + task);
                }
            });
        }
    }

}
