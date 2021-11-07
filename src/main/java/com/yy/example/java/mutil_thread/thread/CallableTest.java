package com.yy.example.java.mutil_thread.thread;

import java.util.concurrent.*;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/7/14 at 上午9:13
 */
public class CallableTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);
        Callable<String > callable = new Callable<String >(){

            @Override
            public String call() throws Exception {

                System.out.println("current thread:"+Thread.currentThread().getName());
                return "Hello world";
            }
        };

        try {
            Future<String> future = service.submit(callable);
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
