package com.yy.example.java.mutil_thread.threadPool;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池的属性的测试
 */
public class ThreadPoolExecutorTest0 {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    /**
     * (1 << COUNT_BITS) = (1 << 29)        -> 536870912  ->   100000000000000000000000000000 -> size: 30
     * CAPACITY          = ((1 << 29) - 1)  -> 536870911  ->    11111111111111111111111111111 -> size: 29
     * ~CAPACITY         = ~((1 << 29) - 1) -> -536870912 -> 11100000000000000000000000000000 -> size: 32
     */
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    /**
     * runState is stored in the high-order bits
     * COUNT_BITS = 29
     * RUNNING    (-1 << 29):   -536870912 -> 11100000000000000000000000000000 -> size: 32
     * SHUTDOWN   (0 << 29):    0          -> 0 ->                             -> size: 1
     * STOP       (1 << 29):    536870912  -> 100000000000000000000000000000   -> size: 30
     * TIDYING    (2 << 29):    1073741824 -> 1000000000000000000000000000000  -> size: 31
     * TERMINATED (3 << 29):    1610612736 -> 1100000000000000000000000000000  -> size: 31
     *
     * 通过实践得出：这里的常量只是状态的边界值。换句话说，每个状态其实是一个范围，具体如下
     * runState: --------   RUNNING  -------- )[ ----------    SHUTDOWN  ---------- )[ ------------    STOP  ---------- )[ -------------    TIDYING  -------- )[  TERMINATED
     * 11100000000000000000000000000000    ~  0  ~  100000000000000000000000000000  ~  1000000000000000000000000000000  ~  1100000000000000000000000000000
     */
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    /**
     * <pre>
     *  Run state is stored in the high-order bits; worker count is stored in the low-order bits. 解释如下:
     *  | ---    高位   ---  |  ---   低位    ---    |
     *  |   -536870912  -->  0  -->  536870912      |
     *  | ---  线程状态  ---  |  ---  线程数量  ---   |
     *  所以线程状态的变化轨迹是从 -536870912 开始递增，一直到 0；线程数量的变化轨迹是从0 开始递增，一直到 536870912
     *  2. ctl直接等于 536870910，再定义两个线程，debug看效果 todo
     *  </pre>
     */

    /**
     * ctl的初始值：-536870912
     * ctl = ctlOf(RUNNING, 0): -536870912 -> 11100000000000000000000000000000 -> size: 32
     */
    private static final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    /**
     * <pre>
     * 由于
     * ~CAPACITY         = ~((1 << 29) - 1) -> -536870912  -> 11100000000000000000000000000000 -> size: 32
     * ctl               = ctlOf(RUNNING, 0): -536870912   -> 11100000000000000000000000000000 -> size: 32
     * 所以
     * c=ctl时, ctl & ~CAPACITY -> -536870912 & -536870912 -> 11100000000000000000000000000000 = -536870912，
     * 所以
     * 随着ctl ++，runStateOf方法结果也是负数，并从-536870912开始递 +1，一直到 0，所以也可以是说负数表示线程状态是RUNNING(运行状态)时
     *
     * 举例：
     * 当第一次ctl ++后，ctl = -536870911  -> 11100000000000000000000000000001
     * 此时，ctl & ~CAPACITY -> -536870911 & -536870912 -> 11100000000000000000000000000001 & 11100000000000000000000000000000
     * NOTE: 当runStateOf等于0时，线程状态就变成了SHUTDOWN
     * </pre>
     */
    private static int runStateOf(int c)     { return c & ~CAPACITY; }

    /**
     * <pre>
     * 由于
     * CAPACITY          = (1 << 29) - 1:    ->  536870911 ->    11111111111111111111111111111 -> size: 29
     * ctl               = ctlOf(RUNNING, 0) -> -536870912 -> 11100000000000000000000000000000 -> size: 32
     * 所以
     * c=ctl时, ctl & CAPACITY   -> -536870912 & 536870911 -> 00000000000000000000000000000000 = 0
     * 所以
     * 随着ctl ++，所以workerCountOf方法结果从0开始递 +1，一直到 536870911
     * </pre>
     */
    private static int workerCountOf(int c)  { return c & CAPACITY; }

    private static int ctlOf(int rs, int wc) { return rs | wc; }

    Lock lock = new ReentrantLock();


    /**
     * <pre>
     * 变换符号就是正数变成负数，负数变成正数。 如对于 -11 和 11，可以通过下面的变换方法将 -11 变成 11
     *
     * // 11
     * [0000 1011]补 --> 取反(~) --> [1111 0100] --> 加 1 --> [1111 0101]补( -11 )
     *
     * // -11
     * [1111 0101]补 --> 取反(~) --> [0000 1010] --> 加 1 --> [0000 1011]补( 11 )
     * 因此变换符号只需要取反操作后加 1 即可
     *
     * int a = -11, b = 11;
     * System.out.println(~a + 1);
     * System.out.println(~b + 1);
     *
     * 链接：https: //www.jianshu.com/p/b677858bc085
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        int a = -11, b = 11;
        System.out.println("(~-11 + 1): " + (~-11 + 1) + " -> -11 toBinaryString: " + Integer.toBinaryString(-11) + " ->  ~-11 toBinaryString: " + Integer.toBinaryString(~-11));
        System.out.println("(~11 + 1): " + (~11 + 1) + " ->  11 toBinaryString: " + Integer.toBinaryString(11) + " ->  ~11 toBinaryString: " + Integer.toBinaryString(~11));
        System.out.println(2 << 31);
        // 1 << 31 含义：数字1往左移31个位置，1本身占一位，所以操作后，32个位置都占满
//        int max = 1 << 31;
//        System.out.println("(1 << 31):     " + max + " -> toBinaryString: " + Integer.toBinaryString(max) + " -> Binary size: " + Integer.toBinaryString(max).length());
//        System.out.println("(1 << 31) - 1: " + max + " -> toBinaryString: " + Integer.toBinaryString(max - 1) + " -> Binary size: " + Integer.toBinaryString(max - 1).length());
//        System.out.println();

        System.out.println("COUNT_BITS 位数:            " + COUNT_BITS);
        System.out.println("CAPACITY (1 << 29) - 1:     " + CAPACITY + " -> toBinaryString: " + Integer.toBinaryString(CAPACITY) + " -> Binary size: " + Integer.toBinaryString(CAPACITY).length());
        System.out.println("~CAPACITY ~((1 << 29) - 1): " + ~CAPACITY + " -> toBinaryString: " + Integer.toBinaryString(~CAPACITY) + " -> Binary size: " + Integer.toBinaryString(~CAPACITY).length());
        System.out.println("2 & ~CAPACITY: " + (2 & ~CAPACITY));
        System.out.println("2 & CAPACITY:  " + (2 & CAPACITY));
        System.out.println();

        System.out.println("RUNNING    (-1 << 29):   " + RUNNING + " -> toBinaryString: " + Integer.toBinaryString(RUNNING) + " -> Binary size: " + Integer.toBinaryString(RUNNING).length());
        System.out.println("SHUTDOWN   (0 << 29):    " + SHUTDOWN + " -> toBinaryString: " + Integer.toBinaryString(SHUTDOWN) + " -> Binary size: " + Integer.toBinaryString(SHUTDOWN).length());
        System.out.println("STOP       (1 << 29):    " + STOP + " -> toBinaryString: " + Integer.toBinaryString(STOP) + " -> Binary size: " + Integer.toBinaryString(STOP).length());
        System.out.println("TIDYING    (2 << 29):    " + TIDYING + " -> toBinaryString: " + Integer.toBinaryString(TIDYING) + " -> Binary size: " + Integer.toBinaryString(TIDYING).length());
        System.out.println("TERMINATED (3 << 29):    " + TERMINATED + " -> toBinaryString: " + Integer.toBinaryString(TERMINATED) + " -> Binary size: " + Integer.toBinaryString(TERMINATED).length());
        System.out.println();


        System.out.println("ctl = ctlOf(RUNNING, 0): " + ctlOf(RUNNING, 0) + " -> toBinaryString: " + Integer.toBinaryString( ctlOf(RUNNING, 0)) + " -> Binary size: " + Integer.toBinaryString(ctlOf(RUNNING, 0)).length());
        System.out.println("runStateOf(ctl): " + runStateOf(ctl.get()) + " -> toBinaryString: " + Integer.toBinaryString(runStateOf(ctl.get())) + " -> Binary size: " + Integer.toBinaryString(runStateOf(ctl.get())).length());
        System.out.println("workerCountOf(ctl): " + workerCountOf(ctl.get()) + " -> toBinaryString: " + Integer.toBinaryString(workerCountOf(ctl.get())) + " -> Binary size: " + Integer.toBinaryString(workerCountOf(ctl.get())).length());
        System.out.println();
        System.out.println("runStateOf(ctl+1): " + runStateOf(ctl.incrementAndGet()) + " -> toBinaryString: " + Integer.toBinaryString(runStateOf(ctl.get())) + " -> Binary size: " + Integer.toBinaryString(runStateOf(ctl.get())).length());
        System.out.println("workerCountOf(ctl+1): " + workerCountOf(ctl.get()) + " -> toBinaryString: " + Integer.toBinaryString(workerCountOf(ctl.get())) + " -> Binary size: " + Integer.toBinaryString(workerCountOf(ctl.get())).length());
        System.out.println();
        System.out.println("runStateOf(100): " + runStateOf(100) + " -> toBinaryString: " + Integer.toBinaryString(runStateOf(100)) + " -> Binary size: " + Integer.toBinaryString(runStateOf(100)).length());
        System.out.println("workerCountOf(100): " + workerCountOf(100) + " -> toBinaryString: " + Integer.toBinaryString(workerCountOf(100)) + " -> Binary size: " + Integer.toBinaryString(workerCountOf(100)).length());
        System.out.println("-536870911: " + workerCountOf(-536870911) + " -> toBinaryString: " + Integer.toBinaryString(-536870911) + " -> Binary size: " + Integer.toBinaryString(-536870911).length());

        System.out.println("536870911 | -536870912:" + (536870911 | -536870912));
        System.out.println("ctlOf(0,-536870912):" + ctlOf(0,-536870912));
        System.out.println("3 | 2 = " + (3 | 2));
        System.out.println("5 | 2 = " + (5 | 2));
        System.out.println();


        System.out.println("00111100 parseInt: " + Integer.parseInt("00111100", 2));
        System.out.println("1 toBinaryString:  " + Integer.toBinaryString(1) + " -> Binary size: " + Integer.toBinaryString(1).length());
        System.out.println("~1 toBinaryString: " + Integer.toBinaryString(~1) + " -> Binary size: " + Integer.toBinaryString(~1).length());
        System.out.println("-1 toBinaryString: " + Integer.toBinaryString(-1) + " -> Binary size: " + Integer.toBinaryString(-1).length());

    }
}
