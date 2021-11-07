package com.yy.example.java.synchronized_;

/**
 * Description: 编写死锁例子
 * <pre>
 *  死锁检测的办法：https://juejin.cn/post/6844903577660424206
 *  1. jstack pid
 *  2. jconsole 进入界面 --> 线程 --> 检测死锁
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-02 at 23:56
 */
public class DeadLockTest {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    System.out.println("concurrent thread:" + Thread.currentThread().getName() + "已拥有o1锁，想要获取o2锁");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                    }
                    synchronized (o2) {
                        // 访问o2
                        System.out.println("concurrent thread:" + Thread.currentThread().getName() + "已拥有o1锁，已拥有o2锁");
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2) {
                    System.out.println("concurrent thread:" + Thread.currentThread().getName() + "已拥有o2锁，想要获取o1锁");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                    }
                    synchronized (o1) {
                        // 访问o1
                        System.out.println("concurrent thread:" + Thread.currentThread().getName() + "已拥有o2锁，已拥有o1锁");
                    }
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
