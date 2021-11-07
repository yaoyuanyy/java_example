package com.yy.example.java.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <pre>
 *   Producer-Consumer Pattern
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-30 at 16:52
 */
public class C2_1_ReentrantLockAndOneConditionTest {

    // 存放数据 0:空；1:满
    int flag = 0;
    ReentrantLock lock;
    Condition condition;

    public C2_1_ReentrantLockAndOneConditionTest() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void put(int data){
        lock.lock();
        // 如果是满的，等待；否则：存满，通知
        try {
            while (flag == 1) {
                condition.await();
            }
            flag = 1;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        // 如果是空的，等待；否则：取空，通知
        try{
            while (flag == 0){
               condition.await();
            }
            flag = 0;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        C2_1_ReentrantLockAndOneConditionTest test = new C2_1_ReentrantLockAndOneConditionTest();

        /**
         *
         * 测试目的：put和get交错出现
         *
         * 结果一
         * put
         * get
         * get
         * put
         * put
         * get
         *
         * 结果二
         * put
         * get
         * put
         * get
         * put
         * get
         *
         */
        for (int i = 0; i < 3; i++) {
            int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.put(tmp);
                    System.out.println("put");
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.get();
                    System.out.println("get ");
                }
            }).start();
        }
    }
}
