package com.yy.example.java.mutil_thread.interviews;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 如何优雅的让3个线程打印ABC
 * <pre>
 * 方案：AtomicInteger
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/19 at 10:05
 */
public class ABC5 {

    static int MAX = 9;
    static AtomicInteger sum = new AtomicInteger(0);

    public static void printA() {
        while (sum.get() < MAX) {
            if (sum.get() % 3 == 0) {
                System.out.println("A");
                sum.incrementAndGet();
            }
        }
    }

    public static void printB() {
        while (sum.get() < MAX) {
            if (sum.get() % 3 == 1) {
                System.out.println("B");
                sum.incrementAndGet();
            }
        }
    }

    public static void printC() {
        while (sum.get() < MAX) {
            if (sum.get() % 3 == 2) {
                System.out.println("C");
                sum.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                printB();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printC();
            }
        }).start();
    }
}