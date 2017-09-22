package com.yy.example.testvolatile;

/**
 * Created by skyler on 2017/2/18.
 */
public class MyVolatileTest {

    public static void main(String[] args) {

        MyVolatileTest test = new MyVolatileTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+" 1started");
                while (true) {
                    //test.write(2);
                    System.out.println(test.read());
                }
                //System.out.println(Thread.currentThread()+" 1ended");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+" 2started");
                while (true) {
                    //System.out.println(test.read());
                    test.write();
                }
                //System.out.println(Thread.currentThread()+" 2ended");
            }
        }).start();

    }

    private volatile int i = 0;

    public void write(){
        i = 4;
    }

    public int read(){
        return i;
    }
}
