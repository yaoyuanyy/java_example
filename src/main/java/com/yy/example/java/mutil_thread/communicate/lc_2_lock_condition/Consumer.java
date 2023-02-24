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
public class Consumer implements Runnable {

    List<String> list;
    Lock lock;
    Condition full;
    Condition empty;

    Consumer(List<String> list, Lock lock, Condition full, Condition empty) {
        this.list = list;
        this.lock = lock;
        this.full = full;
        this.empty = empty;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock(); // 当没抢到锁时，此线程进入锁的派对，当另一个线程调用锁的wait方法时，此线程获取到锁
            try {
                while (list.isEmpty()) {
                    try {
                        System.out.println("队列空了，进入等待");
                        empty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String s = list.remove(0);
                System.out.println("取水果：" + s);
                full.signalAll(); // full 的含义是不空，告诉生产者，我取了一个，容器可能不满了，可以放水果了
            }finally {
                lock.unlock();
            }
        }
    }

    // 生产者消费者架构
    public void architecture(Object obj) {
//        while (true) {
//            synchronized (obj) {
//                while (obj condition) {
//                    obj.wait();
//                }
//                obj.notifyAll();
//            }
//        }
    }
}
