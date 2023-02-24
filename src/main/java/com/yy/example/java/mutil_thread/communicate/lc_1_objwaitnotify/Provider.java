package com.yy.example.java.mutil_thread.communicate.lc_1_objwaitnotify;

import java.util.List;
import java.util.Queue;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/17 at 07:55
 */
public class Provider extends Thread {

    int maxSize = 0;
    List<String> list;

    Provider(List<String> list, int maxSize) {
        this.list = list;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                // 用while 而不是if 的原因
                // where just because your thread quit waiting doesn't mean the condition you are looking for is true:
                //   1. You can get spurious wakeups (meaning that a thread can wake up from waiting without ever having received a notification),
                //   or
                //   2. The condition can get set, but a third thread makes the condition false again by the time the waiting thread wakes up (and reacquires the monitor).
                while (list.size() == maxSize) {
                    try {
                        System.out.println("队列满了，进入等待");
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add("放水果");
                System.out.println("已放入一个水果");
                list.notifyAll();// 告诉消费者，我已经放入水果了，你可以取了
            }
        }
    }
}
