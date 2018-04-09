package com.yy.example.queue.linked_transfer_queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.IntStream;

/**
 * Created by yaoliang on 2017/2/27.
 */
public class TransferBlockingQueueTest {
    public static void main(final String[] args) {

        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();
        new Thread(new TransferBlockingQueueTest().new Producer(queue)).start();
        new Thread(new TransferBlockingQueueTest().new Customer(queue)).start();

    }

    class Producer implements Runnable{

        private LinkedTransferQueue<Integer> queue;

        public Producer(LinkedTransferQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            IntStream.range(0, 5).forEach(a -> {
                System.out.println("producer 等待生产...:"+a);
                queue.add(a);
                System.out.println("producer 生产完成:"+a);
            });
        }
    }

    class Customer implements Runnable{

        private LinkedTransferQueue<Integer> queue;

        public Customer(LinkedTransferQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            IntStream.range(0, 5).forEach(a -> {
                try {
                    System.out.println("Customer 等待消费...:"+a);
                    queue.take();
                    System.out.println("Customer 消费完成:"+a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
