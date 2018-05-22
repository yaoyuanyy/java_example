## 调试GC

- 调试前准备
```
1. 由于测试代码都是在main方法运行，代码运行完程序就结束了，从而此程序对应的内存、栈等内存信息也就释放了。
   此时我们使用jvm的内置工具查看heap stack gc等信息就没有用了。所以我们的代码要在<b>debug模式</b>下运行   

2. 基础知识储备
   - JVM print GC基础
    -verbose.gc或-XX:+PrintGC 开关可显示GC的操作内容
    -XX:+PrintGCDetails #输出详细GC日志模式
    -XX:+PrintGCTimeStamps #输出gc的触发时间
    -XX:+PrintTenuringDistribution #输出每次minor GC后新的存活周期的阈值
    -XX:+PrintFlagsFinal可以列出所有的JVM flag
   http://ifeve.com/useful-jvm-flags-part-8-gc-logging/

3. jvm option参数含义：
   通用配置
   -Xms4096m //最小堆内存
   
   -Xmx4096m //最大堆内存
   
   -Xmn2048m //年轻代大小
   
   -XX:SurvivorRatio=8 //设置eden区和survivor区的内存大小比例，例如8就代表eden和两个survivor区的比例是8:1:1
   
   -XX:MaxTenuringThreshold=15（5~15） //在新生代对象存活次数(经过Minor GC的次数)超过n后，就会晋升到老年代 
   
   -XX:TargetSurvivorRatio=90 //在新生代的对象不一定要满足存活年龄达到MaxTenuringThreshold才能去老年代，当Survivor空间中相同年龄所有对象大小总和大于[Desired survivor size]时，年龄大于或等于该年龄的对象直接进入老年代。[Desired survivor size]=单个survivor大小*TargetSurvivorRatio百分比
   
   -Xss256k //每个线程的堆栈大小
   
   -XX:+DisableExplicitGC //禁止显式调用System.gc()
   
   -XX:+PrintGCDetails #输出详细GC日志模式
   -XX:+PrintGCTimeStamps #输出gc的触发时间
   -XX:+PrintTenuringDistribution #输出每次minor GC后新的存活周期的阈值
   
   JVM参数含义说明参考：
   
   http://ifeve.com/useful-jvm-flags-part-8-gc-logging/
   官网：http://www.oracle.com/technetwork/java/javase/tech/index-jsp-136373.html
```




## 程序运行结果中GC字段的含义说明：
```

例子：
Desired survivor size 1048576 bytes, new threshold 7 (max 15)


例子:
[Times: user=0.06 sys=0.00, real=0.06 secs] – GC事件的持续时间,通过多种分类来进行衡量: 
user – 此次垃圾回收, 垃圾收集线程消耗的所有CPU时间(Total CPU time).
sys – 操作系统调用(OS call) 以及等待系统事件的时间(waiting for system event)
real – 应用程序暂停的时间(Clock time). 由于串行垃圾收集器(Serial Garbage Collector)只会使用单个线程, 所以 real time 等于 user 以及 system time 的总和.


```