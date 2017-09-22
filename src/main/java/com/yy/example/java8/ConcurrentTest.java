package com.yy.example.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by yaoliang on 2016/12/5.
 */
public class ConcurrentTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();
        Future future = executor.submit(() -> {});
        executor.shutdown();
    }
}
