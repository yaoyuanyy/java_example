package com.yy.example.testvolatile;

import org.junit.Test;

/**
 * Created by yaoliang on 2017/2/23.
 */
public class VolatileTest2 {

    // running是否用volatile修饰将产生不同的结果
    volatile boolean running = true;

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (running) {
                    counter++;
                }
                System.out.println("Thread 1 finished. Counted up to " + counter);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Sleep for a bit so that thread 1 has a chance to start
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) { }
                System.out.println("Thread 2 finishing");
                running = false;
            }
        }).start();
    }

    public static void main(String[] args) {
        new VolatileTest2().test();
    }
}
