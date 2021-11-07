package com.yy.example.java.testvolatile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VolatileTest {
    private static final Logger log = LoggerFactory.getLogger(VolatileTest.class);

    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            log.info("ChangeListener in");
            int local_value = MY_INT;
            while ( local_value < 5){
                if( local_value!= MY_INT){
                    log.info("Got Change for MY_INT : {}", MY_INT);
                    local_value= MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {
            log.info("ChangeMaker in");
            int local_value = MY_INT;
            while (MY_INT <5){
                log.info("Incrementing MY_INT to {}", local_value+1);
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}
