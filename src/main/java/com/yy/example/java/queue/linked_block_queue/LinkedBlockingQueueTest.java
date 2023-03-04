package com.yy.example.java.queue.linked_block_queue;

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put("a");
                    queue.put("b");
                    queue.put("c");
                    queue.put("e");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String value1 = queue.take();
                    String value2 = queue.take();
                    String value3 = queue.take();
                    String value4 = queue.take();
                    System.out.println("value1:" + value1);
                    System.out.println("value2:" + value2);
                    System.out.println("value3:" + value3);
                    System.out.println("value4:" + value4);
//                    System.out.printf("%10s\n", value1);
//                    System.out.format("%5s", value2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
