package com.yy.example.queue.priority_block_queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by yaoliang on 2017/2/27.
 */
public class TestPriorityBlockingQueue {
    public static void main(final String[] args) throws InterruptedException {
        PriorityBlockingQueue queue = new PriorityBlockingQueue();

        queue.put("skyler");
        queue.put("skyler2");
        queue.put("skyler3");
        queue.put("skyler4");
        queue.put("skyler5");
        queue.put("skyler6");

        queue.take();
        queue.take();
        queue.take();
        queue.take();
        queue.take();
        queue.take();
        queue.take();
        queue.take();
    }
}
