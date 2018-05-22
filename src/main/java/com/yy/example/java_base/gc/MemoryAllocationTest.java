package com.yy.example.java_base.gc;

/**
 * Description: 测试各个场景内存分配
 * <p>
 * </p>
 * <pre>
 *     提前知晓：
 *     “GC”中接下来的“[DefNew”表示GC发生的区域，这里显示的区域名称与使用的GC收集器是密切相关的。
 *     例如
 *     如果使用的是Serial收集器，新生代名为“Default New Generation”，所以显示的是“[DefNew”；
 *     如果使用的是ParNew收集器，新生代名称为“Parallel New Generation”，所以显示的是“[ParNew”；
 *     如果使用的是Parallel Scavenge收集器，那它配套的新生代称为“PSYoungGen”，所以显示的是“[PSYoungGen”。
 *     老年代和永久代同理，名称也是由收集器决定的。
 *
 *     垃圾收集器参数总结
 *     参数	                         描述
 *     UseSerialGC	虚拟机运行在Client 模式下的默认值，打开此开关后，使用Serial +Serial Old 的收集器组合进行内存回收
 *     UseParNewGC	打开此开关后，使用ParNew + Serial Old 的收集器组合进行内存回收
 *     UseConcMarkSweepGC	打开此开关后，使用ParNew + CMS + Serial Old 的收集器组合进行内存回收。Serial Old 收集器将作为CMS 收集器出现Concurrent Mode Failure失败后的后备收集器使用
 *     UseParallelGC	虚拟机运行在Server 模式下的默认值，打开此开关后，使用ParallelScavenge + Serial Old（PS MarkSweep）的收集器组合进行内存回收
 *     UseParallelOldGC	打开此开关后，使用Parallel Scavenge + Parallel Old 的收集器组合进行内存回收
 *     SurvivorRatio	新生代中Eden 区域与Survivor 区域的容量比值， 默认为8， 代表Eden ：Survivor=8∶1
 *     PretenureSizeThreshold	直接晋升到老年代的对象大小，设置这个参数后，大于这个参数的对象将直接在老年代分配
 *     MaxTenuringThreshold	晋升到老年代的对象年龄。每个对象在坚持过一次Minor GC 之后，年龄就加1，当超过这个参数值时就进入老年代
 *     UseAdaptiveSizePolicy	动态调整Java 堆中各个区域的大小以及进入老年代的年龄
 *     HandlePromotionFailure	是否允许分配担保失败，即老年代的剩余空间不足以应付新生代的整个Eden 和Survivor 区的所有对象都存活的极端情况
 *     ParallelGCThreads	设置并行GC 时进行内存回收的线程数
 *     GCTimeRatio	GC 时间占总时间的比率，默认值为99，即允许1% 的GC 时间。仅在使用Parallel Scavenge 收集器时生效
 *     MaxGCPauseMillis	设置GC 的最大停顿时间。仅在使用Parallel Scavenge 收集器时生效
 *     CMSInitiatingOccupancyFraction	设置CMS 收集器在老年代空间被使用多少后触发垃圾收集。默认值为92%，仅在使用CMS 收集器时生效
 *     UseCMSCompactAtFullCollection	设置CMS 收集器在完成垃圾收集后是否要进行一次内存碎片整理。仅在使用CMS 收集器时生效
 *     CMSFullGCsBeforeCompaction	设置CMS 收集器在进行若干次垃圾收集后再启动一次内存碎片整理。仅在使用CMS 收集器时生效
 *
 *     refer to:
 *     https://jacobchang.cn/experiment-on-jvm.html
 *     http://www.suoniao.com/article/31311
 *     https://cloud.tencent.com/developer/article/1041079
 *
 * </pre>
 * NB.
 * Created by skyler on 2018/5/21 at 下午6:08
 */
public class MemoryAllocationTest {

    private static final int _1MB = 1024 * 1024;

    /**
     * 测试场景：对象优先在 Eden 区分配
     * <p>
     * VM参数：（参数序号对应实验序号）
     * 1. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseParNewGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 2. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseParallelGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 注 -XX:+UseParallelGC是java8默认的gc收集器
     */
    public static void testPriorityAllocationToEden() {
        final byte[] allocation1;
        final byte[] allocation2;
        final byte[] allocation3;
        final byte[] allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; //出现一次 Minor GC
    }

    /**
     * 测试场景：大对象直接进入老年代
     * <p>
     * VM参数：（参数序号对应实验序号）
     * 3. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:PretenureSizeThreshold=3147285
     */
    public static void testBigObjectToOld() {
        final byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     * 测试场景：长期存活的对象将进入老年代
     * -XX:MaxTenuringThreshold=1 -- 对象转移到老年代阀值(每次垃圾回收对象age+1,age大于阀值时对象被移到老年代中）
     * <p>
     * VM参数：（参数序号对应实验序号）
     * 4. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     * 5. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:MaxTenuringThreshold=4 -XX:+PrintTenuringDistribution
     */
    public static void testLongTimeObjectToOld() {
        final byte[] allocation1;
        byte[] allocation2;
        final byte[] allocation3;
        byte[] allocation4;
        allocation1 = new byte[_1MB / 16];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * 测试场景：TenuringThreshold 是动态变化的
     * <p>
     * VM参数：（参数序号对应实验序号）
     * 6. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:MaxTenuringThreshold=4 -XX:+PrintTenuringDistribution
     * <p>
     * 如果在Survivor空间中相同年龄所有对象大小的总和>Survivor空间的一半（ -XX:TargetSurvivorRatio）时，年龄>=该年龄的对象就可以直接进入年老代
     */
    @SuppressWarnings("unused")
    public static void testTenuringThredholdChangeDynamic() {
        final byte[] allocation1;
        byte[] allocation2;
        final byte[] allocation3;
        byte[] allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(final String[] args) {
        testPriorityAllocationToEden();
        //testBigObjectToOld();
    }

}
