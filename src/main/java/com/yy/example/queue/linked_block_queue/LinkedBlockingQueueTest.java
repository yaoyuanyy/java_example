package com.yy.example.queue.linked_block_queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by yaoliang on 2017/2/27.
 *
 * * <pre>
 *     refer to follow:
 *     https://www.jianshu.com/p/28c9d9e34b29
 *     https://juejin.im/entry/599c3e2df265da24874d0598
 *     https://cloud.tencent.com/developer/article/1014694
 * </pre>
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

      /*  queue.put("a");
        queue.put("b");
        queue.put("bb");

        String value = queue.take();
        String value2 = queue.take();
        String value3 = queue.take();
        String value4 = queue.take();

        System.out.printf("%10s\n", value);
        System.out.format("%5s", value);
        queue.put("c");*/

        queue.offer("a");
        queue.peek();
        queue.poll();
    }
}
