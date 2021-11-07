package com.yy.example.java.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <pre>
 *   Producer-Consumer Pattern：通过ReentrantLock 和 Condition实现，以及使用了数组 int[] 作为容器和边界条件
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-30 at 16:52
 */
public class C2_2_ReentrantLockAndTwoConditionTest {

    int[] items;
    ReentrantLock lock;
    Condition notEmpty;
    Condition notFull;
    int putIndex;
    int takeIndex;
    int count;

    public C2_2_ReentrantLockAndTwoConditionTest(int size) {
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
        items = new int[size];
    }

    public void put(int data) throws InterruptedException {
        lock.lockInterruptibly();
        try{
            while (count == items.length) {
                // 此时数据满了，不满条件开始等待
                notFull.await();
            }
            items[putIndex++] = data;
            if(putIndex == items.length) {
                putIndex = 0;
            }
            count++;
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public int get() throws InterruptedException {
        lock.lockInterruptibly();
        try{
            while (count == 0) {
                // 此时数据空了，不空条件开始等待
                notEmpty.await();
            }
            int data = items[takeIndex++];
            if(takeIndex == items.length) {
                takeIndex = 0;
            }
            count--;
            notFull.signalAll();
            return data;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        C2_2_ReentrantLockAndTwoConditionTest test = new C2_2_ReentrantLockAndTwoConditionTest(3);

        /**
         * 测试目的：篮子里最多放3个物品，再取就陷入等待，等待有人取走后才能往篮子里再放；
         *          取走最多能取3个，再取就陷入等待，等待有人往篮子里放才能再取
         */
        for (int i = 0; i < 10; i++) {
            int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        test.put(tmp);
                        System.out.println("put" + tmp);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int data = test.get();
                        System.out.println("get" + data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
