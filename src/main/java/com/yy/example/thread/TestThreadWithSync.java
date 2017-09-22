package com.yy.example.thread;

/**
 * Created by yaoliang on 2017/2/17.
 */
class PrintDemo2 {
    public void printCount() {
        try {
            for(int i = 10; i > 0; i--) {
                System.out.println("Counter   ---   "  + i );
            }
        }catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}

class ThreadDemo2 extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo2  PD;

    ThreadDemo2( String name,  PrintDemo2 pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        synchronized (PD) {
            System.out.println(PD.toString());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PD.printCount();
            System.out.println("Thread " +  threadName + " exiting.");
        }
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class TestThreadWithSync {
    public static void main(String args[]) {
        TestThreadWithSync ttws = new TestThreadWithSync();
        //两个线程同一个对象锁
        //ttws.test1();
        //两个线程不同的对象锁
        ttws.test2();
    }

    public void test1() {
        PrintDemo2 PD = new PrintDemo2();

        ThreadDemo2 T1 = new ThreadDemo2( "Thread - 1 ", PD );
        ThreadDemo2 T2 = new ThreadDemo2( "Thread - 2 ", PD );

        T1.start();
        T2.start();

        // wait for threads to end
        try {
            T1.join();
            T2.join();
        }catch( Exception e) {
            System.out.println("Interrupted");
        }
    }

    public void test2() {
        PrintDemo2 PD = new PrintDemo2();
        PrintDemo2 PD2 = new PrintDemo2();

        ThreadDemo2 T1 = new ThreadDemo2( "Thread - 1 ", PD );
        ThreadDemo2 T2 = new ThreadDemo2( "Thread - 2 ", PD2 );

        T1.start();
        T2.start();

        // wait for threads to end
        try {
            T1.join();
            T2.join();
        }catch( Exception e) {
            System.out.println("Interrupted");
        }
    }

}

