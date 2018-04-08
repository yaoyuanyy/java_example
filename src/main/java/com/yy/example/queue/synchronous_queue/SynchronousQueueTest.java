package com.yy.example.queue.synchronous_queue;

import java.util.concurrent.SynchronousQueue;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/4/7 at 下午10:54
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue queue = new SynchronousQueue();
        queue.put(1);
        queue.put(2);

        queue.take();

    }
}
