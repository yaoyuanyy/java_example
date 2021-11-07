package com.yy.example.java.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * Description: 读写锁 - 死锁的演示
 * <pre>
 * "main" #1 prio=5 os_prio=31 tid=0x00007ff8cd017000 nid=0x1003 waiting on condition [0x0000700006ff0000]
 *    java.lang.Thread.State: WAITING (parking)
 * 	at sun.misc.Unsafe.park(Native Method)
 * 	- parking to wait for  <0x000000076afcd108> (a java.util.concurrent.locks.ReentrantReadWriteLock$NonfairSync)
 * 	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
 * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
 * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireQueued(AbstractQueuedSynchronizer.java:870)
 * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire(AbstractQueuedSynchronizer.java:1199)
 * 	at java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock.lock(ReentrantReadWriteLock.java:943)
 * 	at com.yy.example.lock_reentrantlock.readwrite.ReadWriteLockTest1.main(ReadWriteLockTest1.java:26)
 *
 * Answer:
 *   上面这段代码属于锁升级，会产生死锁，因为同一个线程在没有释放读锁的情况下就去申请写锁是不成立的，读写和写写是互斥的。
 *
 *   可以看到 ReentrantReadWriteLock 不支持锁升级，只支持锁降级。锁降级的意思就是对同一线程从写锁变成读锁，锁升级的意思就是对同一线程从读锁变成写锁
 *
 *   链接：https://www.jianshu.com/p/c54a86269ce9
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-14 at 15:59
 */
public class C4_ReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        WriteLock writeLock = readWriteLock.writeLock();
        ReadLock readLock = readWriteLock.readLock();

        readLock.lock();
        System.out.println("read locked");
        // 读锁没有释放，就去获取写锁。从而造成死锁
        writeLock.lock();
        System.out.println("write locked");
    }
}
