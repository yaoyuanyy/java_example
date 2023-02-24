package com.yy.example.java.mutil_thread.communicate.lc_3_blocking_queue;

import java.util.List;
import java.util.concurrent.BlockingQueue;
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

    BlockingQueue<String> blockingQueue;

    Provider(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                blockingQueue.put("放水果");
                System.out.println("生产者已放入一个水果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
