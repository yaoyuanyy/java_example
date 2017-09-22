package com.yy.example.executor;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        ScheduledFuture scheduledFuture = executorService.schedule(() -> {
            System.out.println("run --- "+ Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(() -> {System.out.println("FixedDelay" + Thread.currentThread().getName());},1000, 2000, TimeUnit.MILLISECONDS);


    }


}