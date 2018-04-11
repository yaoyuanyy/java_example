package com.yy.example.queue.concurrent_linked_queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <pre>
 *     refer to:
 *     https://www.ibm.com/developerworks/cn/java/j-lo-concurrent/index.html
 * </pre>
 * Created by yaoliang on 2017/2/27.
 */
public class ConcurrentLinkedQueueTest {
    public static void main(final String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.add("a");
                    queue.add("b");
                    queue.offer("c");
                    queue.add("d");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String value = queue.peek();

                    String value2 = queue.poll();
                    String value3 = queue.poll();
                    String value4 = queue.poll();

                    System.out.printf("%10s\n", value);
                    System.out.format("%5s", value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
