package com.yy.example.java.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by skyler on 2017/2/27.
 * <pre>
 *     refer to follow:
 *     http://www.importnew.com/9281.html
 *     https://www.jianshu.com/p/28387056eeb4
 *     https://www.jianshu.com/p/e7659436538b
 * </pre>
 */
public class C2_0_WithConditionTest {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        // Step1: 用两个线程来追踪源码
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    System.out.println("线程0");
                    System.out.printf("%s\n", "我正在等一个信号");
                    condition.await();
                    System.out.printf("%s\n", "我收到一个信号，我去浪了");

                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    System.out.println("线程1");
                   // Thread.sleep(1000*60*15);
                    System.out.printf("%s\n", "即将释放一个信息");
                    condition.signal();
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

        // Step2: 当两个线程的时候弄明白之后，再加一个线程，继续走源码
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    lock.lock();
//                    System.out.println("线程2");
//                    System.out.printf("%s\n", "线程2正在等一个信号");
//                    condition.await();
//                    System.out.printf("%s\n", "线程2收到一个信号，我去浪了");
//
//                }catch(Exception e){
//                    System.out.printf("%s\n", e);
//                }finally {
//                    lock.unlock();
//                }
//            }
//        }).start();
    }

}
