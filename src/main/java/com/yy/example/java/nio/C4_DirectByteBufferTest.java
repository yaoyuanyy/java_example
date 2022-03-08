package com.yy.example.java.nio;

import sun.nio.ch.DirectBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

/**
 * Description: 观看堆外内存的回收
 * <pre>
 *  分配 1G 的 DirectByteBuffer，等待用户输入后，复制为 null，之后阻塞持续观察堆外内存变化
 *  参考：https://www.cnkirito.moe/nio-buffer-recycle/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-11-14 at 20:28
 */
public class C4_DirectByteBufferTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
        // 交互操作：等待输入，便于visualVM可视化观察
        System.out.println("wait for inputing ...");
        System.in.read();
        System.out.println("wait for null ...");
        byteBuffer.get();
        byteBuffer = null; // (1)赋值null观察是否释放内存
        // System.gc(); // (2)手动释放内存
        // ((DirectBuffer)byteBuffer).cleaner().clean(); // (3)调用Cleaner释放内存
        // 程序暂停住
        new CountDownLatch(1).await();
    }
}
