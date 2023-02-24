package com.yy.example.java.mutil_thread.interviews;

import java.util.concurrent.CountDownLatch;

/**
 * Description: 如何优雅的让3个线程打印ABC
 * <pre>
 * 方案：打印一次 A B C可以，打印多次不能实现，因为CountDownLatch必须等到count 为空，才会实现线程通信
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/19 at 10:05
 */
public class ABC6 {

    private static CountDownLatch countDownLatchB = new CountDownLatch(1);
    private static CountDownLatch countDownLatchC = new CountDownLatch(1);

    public static void printA() throws InterruptedException {
        System.out.println("A");
        countDownLatchB.countDown();
    }

    public static void printB() throws InterruptedException {
        countDownLatchB.await();
        System.out.println("B");
        countDownLatchC.countDown();
    }

    public static void printC() throws InterruptedException {
        countDownLatchC.await();
        System.out.println("C");
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}