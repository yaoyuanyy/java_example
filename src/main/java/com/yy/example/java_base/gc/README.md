## 调试GC

- 调试前准备
```
1. 由于测试代码都是在main方法运行，代码运行完程序就结束了，从而此程序对应的内存、栈等内存信息也就释放了。
   此时我们使用jvm的内置工具查看heap stack gc等信息就没有用了。所以我们的代码要在<b>debug模式</b>下运行

2. jvm option参数含义：
   -verbose.gc或-XX:+PrintGC 开关可显示GC的操作内容
   -XX:+PrintGCDetails #输出详细GC日志模式
   -XX:+PrintGCTimeStamps #输出gc的触发时间
   -XX:+PrintTenuringDistribution #输出每次minor GC后新的存活周期的阈值
   -XX:+PrintFlagsFinal可以列出所有的JVM flag
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