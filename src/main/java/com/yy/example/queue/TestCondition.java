package com.yy.example.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by skyler on 2017/2/27.
 * <pre>
 *     refer to follow:
 *     http://www.importnew.com/9281.html
 *     https://www.jianshu.com/p/28387056eeb4
 * </pre>
 */
public class TestCondition {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    System.out.printf("%s\n", "我正在等一个信号");
                    condition.await();
                    System.out.printf("%s\n", "我收到一个信号，我去浪了");

                }catch(Exception e){
                    System.out.printf("%s\n", e);
                }finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            try{
                lock.lock();
                Thread.sleep(1000);
                System.out.printf("%s\n", "即将释放一个信息");
                condition.signal();
            }catch(Exception e){
                System.out.printf("%s\n", e);
            }finally {
                lock.unlock();
            }
        }).start();
    }

}
