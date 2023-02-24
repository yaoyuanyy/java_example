package com.yy.example.java.mutil_thread.interviews;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 如何优雅的让3个线程打印ABC
 * <pre>
 * 方案：ReentrantLock + condition
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/19 at 10:05
 */
public class ABC4 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();

    static int MAX = 9;
    static int value = 0;

    public static void printA() {
        while (value < MAX) {
            lock.lock();
            try {
                while (value % 3 == 0) {
                    System.out.println("A");
                    value++;
                    conditionA.await();
                }
                conditionB.signalAll();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public static void printB() {
        while (value < MAX) {
            lock.lock();
            try {
                while (value % 3 == 1) {
                    System.out.println("B");
                    value++;
                    conditionB.await();
                }
                conditionC.signalAll();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public static void printC() {
        while (value < MAX) {
            lock.lock();
            try {
                while (value % 3 == 2) {
                    System.out.println("C");
                    value++;
                    // 当前线程等待，知道被signal or interrupt，同时，condition所在锁被释放。
                    // 也就意味着此时其他的线程可以获取锁了
                    conditionC.await();
                }
                conditionA.signalAll();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
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