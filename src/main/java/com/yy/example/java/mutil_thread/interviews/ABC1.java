package com.yy.example.java.mutil_thread.interviews;

/**
 * Description: 如何优雅的让3个线程打印ABC
 * <pre>
 * 方案：synchronized + 全局类变量 current
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/19 at 10:05
 */
public class ABC1 implements Runnable{

    /** 类变量 */
    static final Object lock = new Object();
    int target;
    /** 类变量，变量属于类，而不是实例，所以多个线程可以共同对其值进行更新 */
    static int current;
    /** 类变量 */
    static int max = 10;

    public ABC1(int target) {
        this.target = target;
    }

    @Override
    public void run() {
        printABC();
    }

    public void printABC() {
        while (current < max) {
            synchronized (lock) {
                // current < max 的原因是
                if((current < max) && (current % 3 == target)) {
                    System.out.println((char)('A' + current % 3));
                    current++;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ABC1(0)).start();
        new Thread(new ABC1(1)).start();
        new Thread(new ABC1(2)).start();

        try {
            Thread.sleep(1000*10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
