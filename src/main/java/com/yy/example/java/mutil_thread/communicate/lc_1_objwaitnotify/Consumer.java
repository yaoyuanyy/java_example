package com.yy.example.java.mutil_thread.communicate.lc_1_objwaitnotify;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/17 at 07:55
 */
public class Consumer extends Thread {

    List<String> list;

    Consumer(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) { // 当没抢到锁时，此线程进入锁的派对，当另一个线程调用锁的wait方法时，此线程获取到锁
                while (list.isEmpty()) {
                    try {
                        System.out.println("队列空了，进入等待");
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String s = list.remove(0);
                System.out.println("取水果：" + s);
                list.notifyAll(); // 告诉生产者，我取了一个，容器可能不满了，可以放水果了
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
