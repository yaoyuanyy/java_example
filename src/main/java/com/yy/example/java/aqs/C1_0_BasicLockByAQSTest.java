package com.yy.example.java.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 *     使用三个线程通过debug的方式，从而观察 AQS 和 ReentrantLock内部的线程排队，唤醒等场景。注意：breakpoint处 suspend选择 thread模式
 *     refer to:
 *     https://javadoop.com/2017/07/20/AbstractQueuedSynchronizer-2/
 * </pre>
 */
public class C1_0_BasicLockByAQSTest {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();

        Thread thread0 = new Thread(() -> {
            data.outPut("y0");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread0.start();

        new Thread(() -> {
            data.outPut("y1");
        }).start();

//        new Thread(() -> {
//            data.outPut("y3");
//        }).start();

        Thread.sleep(1000);
        thread0.interrupt();
        System.out.println("1");
    }
}
/**
 * 模拟共享资源
 */
class Data{
    Lock lock = new ReentrantLock();
    public void outPut(String name) {
        lock.lock();
        try {
            // 模拟业务逻辑。此处简单起见仅输出
            System.out.println("name：" + name + " -> Thread name:" + Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }
    }
}


