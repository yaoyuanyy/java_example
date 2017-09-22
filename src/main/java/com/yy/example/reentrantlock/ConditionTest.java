package com.yy.example.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        ReentrantLock lock = new ReentrantLock();
        Condition con0 = lock.newCondition();
        Condition con1 = lock.newCondition();
        Condition con2 = lock.newCondition();

        //
//        executorService.submit(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("start concurrent thread:"+Thread.currentThread().getName());
//            await(lock, con1);
//            System.out.println("end concurrent thread:"+Thread.currentThread().getName());
//        });
//
//        //
//        executorService.submit(() -> {
//            System.out.println("start concurrent2 thread:"+Thread.currentThread().getName());
//            await(lock, con2);
//            System.out.println("end concurrent2 thread:"+Thread.currentThread().getName());
//        });
//
//        //
//        executorService.submit(() -> {
//            System.out.println("start concurrent3 thread:"+Thread.currentThread().getName());
//            await(lock, con3);
//            System.out.println("end concurrent3 thread:"+Thread.currentThread().getName());
//        });


        // 研究源码的时候不适合用ExecutorService，要用最简单的方式，防止ExecutorService牵扯到我们要研究的代码
        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("start concurrent0 thread:"+Thread.currentThread().getName());
                await(lock, con0);
                System.out.println("end concurrent0 thread:"+Thread.currentThread().getName());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start concurrent1 thread:"+Thread.currentThread().getName());
                await(lock, con1);
                System.out.println("end concurrent1 thread:"+Thread.currentThread().getName());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start concurrent2 thread:"+Thread.currentThread().getName());
                await(lock, con2);
                System.out.println("end concurrent2 thread:"+Thread.currentThread().getName());
            }
        }).start();


        // 此处睡眠的目的：防止下面的singal方法运行于上面的任务之前
        Thread.sleep(1000);

        singal(lock, con2,2);
        singal(lock, con0, 0);
        singal(lock, con1, 1);

        //executorService.shutdown();
    }


    private static void await(ReentrantLock lock, Condition con) {
        try {
            lock.lock();
            con.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void singal(ReentrantLock lock, Condition con, int num) {
        try {
            lock.lock();
            System.out.println("signal"+num);
            con.signal();
            //Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
