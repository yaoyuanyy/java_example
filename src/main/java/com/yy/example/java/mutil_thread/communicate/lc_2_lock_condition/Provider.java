package com.yy.example.java.mutil_thread.communicate.lc_2_lock_condition;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/17 at 07:55
 */
public class Provider implements Runnable {

    int maxSize;
    List<String> list;

    Lock lock;
    Condition full;
    Condition empty;

    Provider(List<String> list, int maxSize, Lock lock, Condition full, Condition empty) {
        this.list = list;
        this.maxSize = maxSize;
        this.lock = lock;
        this.full = full;
        this.empty = empty;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try{
                while (list.size() == maxSize) {
                    try {
                        System.out.println("队列满了，进入等待");
                        full.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add("放水果");
                System.out.println("已放入一个水果");
                empty.signalAll();// 告诉消费者，我已经放 入水果了，你可以取了
            }finally {
                lock.unlock();
            }
        }
    }
}
