package com.yy.example.java.mutil_thread.communicate.lc_3_blocking_queue;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/17 at 07:55
 */
public class Consumer implements Runnable {

    BlockingQueue<String> blockingQueue;

    Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String res = blockingQueue.take();
                System.out.println("消费者已取出一个水果:" + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
