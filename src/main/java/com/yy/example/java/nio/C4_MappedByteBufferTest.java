package com.yy.example.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Scanner;

/**
 * Description:
 * <pre>
 * 一步一步查看系统调用
 *
 * 1. 理论：
 * https://www.cnblogs.com/huxiao-tee/p/4660352.html
 * https://zthinker.com/archives/directbytebuffer%E4%B8%8Emappedbytebuffer
 *
 * 2. java mmap
 * https://www.happycoders.eu/java/filechannel-bytebuffer-memory-mapped-file-locks/
 *
 * 3. 实战：
 * 查看系统调用的过程：单步进行
 * $ cd /root/project/strace_test
 * $ strace -ff -o out java MmapTest
 *
 * 4. 实践：
 * https://www.cnkirito.moe/file-io-best-practise/
 * http://neoremind.com/2018/12/2018-polar-race-java-no-1/comment-page-1/#comment-128139
 *
 * 5.2 ByteBuffer的使用实际遇到的问题场景 RednaxelaFX大神
 * 先看5.1
 * https://www.cnkirito.moe/nio-buffer-recycle/
 *
 * 5.1 Direct和Heap类型Buffer的本质
 * 首选说说JVM是怎么进行IO操作的。
 *
 * JVM在需要通过操作系统调用完成IO操作，比如可以通过read系统调用完成文件的读取。read的原型是：ssize_t read(int fd,void *buf,size_t nbytes)，和其他的IO系统调用类似，一般需要缓冲区作为其中一个参数，该缓冲区要求是连续的。
 *
 * Buffer分为Direct和Heap两类，下面分别说明这两类buffer。
 *
 * Heap
 * Heap类型的Buffer存在于JVM的堆上，这部分内存的回收与整理和普通的对象一样。Heap类型的Buffer对象都包含一个对应基本数据类型的数组属性（比如：final **[] hb），数组才是Heap类型Buffer的底层缓冲区。
 * 但是Heap类型的Buffer不能作为缓冲区参数直接进行系统调用，主要因为下面两个原因。
 *
 * JVM在GC时可能会移动缓冲区（复制-整理），缓冲区的地址不固定。
 *
 * 系统调用时，缓冲区需要是连续的，但是数组可能不是连续的（JVM的实现没要求连续）。
 *
 * 所以使用Heap类型的Buffer进行IO时，JVM需要产生一个临时Direct类型的Buffer，然后进行数据复制，再使用临时Direct的Buffer作为参数进行操作系统调用。这造成很低的效率，主要是因为两个原因：
 *
 * 需要把数据从Heap类型的Buffer里面复制到临时创建的Direct的Buffer里面。
 *
 * 可能产生大量的Buffer对象，从而提高GC的频率。所以在IO操作时，可以通过重复利用Buffer进行优化。
 *
 * Direct
 * Direct类型的buffer，不存在于堆上，而是JVM通过malloc直接分配的一段连续的内存，这部分内存成为直接内存，JVM进行IO系统调用时使用的是直接内存作为缓冲区。
 * -XX:MaxDirectMemorySize，通过这个配置可以设置允许分配的最大直接内存的大小（MappedByteBuffer分配的内存不受此配置影响）。
 * 直接内存的回收和堆内存的回收不同，如果直接内存使用不当，很容易造成OutOfMemoryError。JAVA没有提供显示的方法去主动释放直接内存，sun.misc.Unsafe类可以进行直接的底层内存操作，通过该类可以主动释放和管理直接内存。同理，也应该重复利用直接内存以提高效率。
 *
 * https://blog.51cto.com/u_13013666/1943055
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-11-10 at 09:40
 */
public class C4_MappedByteBufferTest {

    public static void main(String[] args) throws IOException {
        boolean stop = true;
        RandomAccessFile randomAccessFile = null;
        FileChannel fileChannel = null;
        MappedByteBuffer mappedByteBuffer = null;
        while (stop) {
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            System.out.println("number:" + number);

            if (number == 0) {
                randomAccessFile = new RandomAccessFile("/Users/yaoliang/test.sh", "rw");
            }else if (number == 1) {
                fileChannel = randomAccessFile.getChannel();
            }else if (number == 2) {
                mappedByteBuffer = fileChannel.map(MapMode.READ_WRITE, 0, 1024 * 1024 * 10);
            } else if (number == 3) {
                mappedByteBuffer.put((byte) 'f');
                System.out.println(mappedByteBuffer);
            }else if(number == 4) {
                int position = mappedByteBuffer.position();
                System.out.println("position: " + position + " value:" + (char) mappedByteBuffer.get(position));
            }else if(number == 9){
                stop = false;
            }else {
                System.out.println("go on, stop -> 9");
            }
        }
        mappedByteBuffer.clear();
        fileChannel.close();
        randomAccessFile.close();
    }
}
