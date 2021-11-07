package com.yy.example.java.queue.array_block_queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by yaoliang on 2017/2/27.
 */
public class ArrayBlockingQueueTest {
    public static void main(final String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put("a");
                    queue.put("b");
                    queue.put("bb");
                    queue.put("b2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String value = queue.take();
                    String value2 = queue.take();
                    String value3 = queue.take();
                    String value4 = queue.take();

                    System.out.printf("%10s\n", value);
                    System.out.format("%5s", value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
