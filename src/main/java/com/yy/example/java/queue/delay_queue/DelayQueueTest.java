package com.yy.example.java.queue.delay_queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 *     refer to:
 *     https://cloud.tencent.com/developer/article/1014694
 * </pre>
 * Created by yaoliang on 2017/2/27.
 */
public class DelayQueueTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue =new DelayQueue<>();
        long now = System.currentTimeMillis();

        System.out.println("current time in ms: " + now);
        DelayedElement ob1=new DelayedElement("e1", now + 1000*60*10);
        DelayedElement ob2=new DelayedElement("e2", now + 1000*60*20);
        DelayedElement ob3=new DelayedElement("e3", now + 1000*60*10);
        delayQueue.offer(ob1);
        delayQueue.offer(ob2);
        delayQueue.offer(ob3);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }


        while(delayQueue.size() > 0){
            try {
                DelayedElement e = delayQueue.take();
                System.out.println("current time in ms: " + System.currentTimeMillis() + ", element:" + e.name);

            } catch (InterruptedException e) {
                throw new RuntimeException( e );
            }

        }
    }

    static class DelayedElement implements Delayed {
        public long time;
        public String name;

        public DelayedElement(String name, long time){
            this.name = name;
            this.time = time;
        }
        // 返回值是正数：当前对象大于传入参数(指定对象)
        @Override
        public int compareTo(Delayed o) {
            if(o == this) {
                return 0;
            }
            if(o instanceof DelayedElement) {
                DelayedElement t = (DelayedElement)o;
                long diff = this.time - t.time;
                if(diff < 0) {
                    return -1;
                }else if(diff > 0){
                    return 1;
                }else {
                    return 0;
                }
            }
            long diff = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
            return diff < 0 ? -1 : (diff > 0 ? 1 : 0);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long r =  unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
            //System.out.println("delay:" + r);
            return r;
        }

    }
}