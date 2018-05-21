## 调试GC

- 调试前准备
```
1. 由于测试代码都是在main方法运行，代码运行完程序就结束了，从而此程序对应的内存、栈等内存信息也就释放了。
   此时我们使用jvm的内置工具查看heap stack gc等信息就没有用了。所以我们的代码要在<b>debug模式</b>下运行

2. jvm option参数含义：
   -XX:+PrintGCDetails #输出详细GC日志模式
   -XX:+PrintGCTimeStamps #输出gc的触发时间
   -XX:+PrintTenuringDistribution #输出每次minor GC后新的存活周期的阈值
```




## 程序运行结果中GC字段的含义说明：
```

例子：Desired survivor size 1048576 bytes, new threshold 7 (max 15)


```