package com.yy.example.mutil_thread.threadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest0 {

    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;

        // runState is stored in the high-order bits
        int RUNNING    = -1 << COUNT_BITS;
        int SHUTDOWN   =  0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;

        System.out.println("5 << 3:" + (5 << 3));
        System.out.println("RUNNING: toBinaryString" + Integer.toBinaryString(RUNNING));
        System.out.println("CAPACITY toBinaryString:" + Integer.toBinaryString(CAPACITY));
        System.out.println("CAPACITY toBinaryString length:" + Integer.toBinaryString(CAPACITY).length());
        System.out.println("CAPACITY:" + CAPACITY);
        System.out.println("~CAPACITY:" + ~CAPACITY);
        System.out.println("2 & ~CAPACITY:" + (2 & ~CAPACITY));
        System.out.println("2 & CAPACITY:" + (2 & CAPACITY));

        System.out.println("RUNNING:" + RUNNING);
        System.out.println("SHUTDOWN:" + SHUTDOWN);
        System.out.println("STOP:" + STOP);
        System.out.println("TIDYING:" + TIDYING);
        System.out.println("TERMINATED:" + TERMINATED);

        AtomicInteger ctl = new AtomicInteger(RUNNING | 0);
        System.out.println("ctl:" + ctl.get());

        System.out.println("3 | 2 = " + (3 | 2));
        System.out.println("5 | 2 = " + (5 | 2));

        System.out.println("9:" + Integer.toBinaryString(9));
        System.out.println("~9:" + Integer.toBinaryString(~9));

        System.out.println("00111100 parseInt:" + Integer.parseInt("00111100", 2));
        System.out.println("1 toBinaryString:" + Integer.toBinaryString(1));
        System.out.println("-1 toBinaryString:" + Integer.toBinaryString(-1));
        System.out.println("~1 toBinaryString:" + Integer.toBinaryString(~1));
        System.out.println("Integer.toBinaryString(~1) parseInt:" + Long.parseLong(Integer.toBinaryString(~1), 2));

    }
}
