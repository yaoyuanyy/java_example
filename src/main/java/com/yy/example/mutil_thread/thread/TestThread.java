package com.yy.example.mutil_thread.thread;

/**
 * Created by yaoliang on 2017/2/17.
 */
class PrintDemo3 {

    public void printCount() {
        synchronized(this) {
            synchronized("sss") {
                try {
                    for (int i = 10; i > 0; i--) {
                        System.out.println("Counter   ---   " + i);
                    }
                } catch (Exception e) {
                    System.out.println("Thread  interrupted.");
                }
            }
        }
    }
}

class ThreadDemo3 extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo3  PD;

    ThreadDemo3( String name,  PrintDemo3 pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PD.printCount();
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class TestThread {
    public static void main(String args[]) {
        TestThread tt = new TestThread();
        tt.test1();
    }

    public void test1() {
        PrintDemo3 PD = new PrintDemo3();
        PrintDemo3 PD3 = new PrintDemo3();

        ThreadDemo3 T1 = new ThreadDemo3( "Thread - 1 ", PD );
        ThreadDemo3 T2 = new ThreadDemo3( "Thread - 2 ", PD3 );

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


