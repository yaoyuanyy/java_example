package com.yy.example.queue.delay_queue;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-07-23 at 16:14
 */
public class DelayQueueTest2 {

    public static void main(String[] args) throws InterruptedException {

        long time = System.currentTimeMillis() + 1000 * 5;
        System.out.println(NANOSECONDS.toNanos(time - System.currentTimeMillis()));

        DelayQueue<MyDelayed> delayQueue = new DelayQueue<>();
        delayQueue.add(new MyDelayed(time));

        System.out.println(new Date());
        MyDelayed myDelayed = delayQueue.take();
        System.out.println(myDelayed.getDate());

    }


    static class MyDelayed implements Delayed {
        private volatile long time;

        public MyDelayed(long time) {
            this.time = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
             return unit.toNanos(time - System.currentTimeMillis());
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }

        public Date getDate() {
            return new Date();
        }
    }
}
