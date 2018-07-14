package com.yy.example.mutil_thread.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/23 at 下午3:46
 */
public class ExecutorsTest {

    public static void main(final String[] args) {

        BasicThreadFactory factory = new BasicThreadFactory.Builder().namingPattern("myspringbean-thread-%d").build();
        final ExecutorService service = Executors.newFixedThreadPool(4, factory);
        executeTask(service);


        ThreadFactory factory2 = new ThreadFactoryBuilder().setNameFormat("myspringbean-thread-%d").build();
        final ExecutorService service1 = Executors.newFixedThreadPool(2, factory2);
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
