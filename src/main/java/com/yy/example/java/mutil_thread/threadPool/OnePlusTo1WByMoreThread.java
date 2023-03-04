package com.yy.example.java.mutil_thread.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 快手二面面试题：100个线程，计算1-10000的求和
 * NB.
 * Created by skyler on 2023/3/3
 */
public class OnePlusTo1WByMoreThread {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        OnePlusTo1WByMoreThread main = new OnePlusTo1WByMoreThread();
        main.getSum();
    }

    public int getSum() {
        int count = 100;
        ExecutorService executor = Executors.newFixedThreadPool(count); // 定义一个固定数量的线程池
        CountDownLatch cdl = new CountDownLatch(count);
        List<Future<Integer>> list = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            final int iTmp = i;
            Future f = executor.submit(() -> {
                int sumTmp = 0;
                for (int j = 0; j < count; j++) {
                    sumTmp = sumTmp + j * count + iTmp;
                }
                cdl.countDown();
                return sumTmp;
            });
            list.add(f);
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            try {
                sum += list.get(i).get();
            } catch (Exception e) {
            }
        }
        executor.shutdown();
        System.out.println("sum:" + (sum + 10000));
        return sum;
    }
}