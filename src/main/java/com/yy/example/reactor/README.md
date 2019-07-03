# 响应式编程

## 架构

### 代码api总体结构
Reactive Stream API 介绍
让我们来简要看一下 Reactive Stream API。它只提供了四个接口。

```aidl
Publisher：是元素（消息）序列的提供者，根据它的订阅者的需求，来发布这些元素（消息）。
public interface Publisher<T> {
    public void subscribe(Subscriber<? super T> s);
}

Subscriber：当通过 Publisher.subscribe(Subscriber) 注册后，它将通过 Subscriber.onSubscribe(Subscription) 来接收消息。
public interface Subscriber<T> {
    public void onSubscribe(Subscription s);
    public void onNext(T t);
    public void onError(Throwable t);
    public void onComplete();
}

Subscription：代表了消息从 Publisher 到 Subscriber 的一个一对一的生命周期。
public interface Subscription {
    public void request(long n);
    public void cancel();
}

Processor：继承了 Publisher 和 Subscriber，用于转换发布者到订阅者之间管道中的元素。Processor<T,R> 订阅类型为 T 的数据元素，接收并转换为类型为 R 的数据，然后发布变换后的数据。
public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {
}
```
### 结构图
![结构图](https://github.com/ZhongyangMA/images/raw/master/webflux-streaming-demo/processor.png)

### 发布者和订阅者之间的典型交互顺序图
![](https://github.com/ZhongyangMA/images/raw/master/webflux-streaming-demo/publisher-subscriber.png)


## 聊聊reactive streams的backpressure

- 原文  https://juejin.im/post/5a5b4929f265da3e3e33bce9
- 参考：https://www.dnocm.com/articles/almond/java%20projectreactor-flux/

```
@Test
    public void testShowReactiveStreams() throws InterruptedException {
        Flux.interval(Duration.ofMillis(1000))
                .take(500)
                .subscribe(e -> LOGGER.info("get {}",e));

        Thread.sleep(5*60*1000);
    }
```
输出实例如下：
```
18:52:34.118 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
18:52:35.157 [parallel-2] INFO com.example.demo.FluxTest - get 0
18:52:36.156 [parallel-2] INFO com.example.demo.FluxTest - get 1
18:52:37.156 [parallel-2] INFO com.example.demo.FluxTest - get 2
18:52:38.159 [parallel-2] INFO com.example.demo.FluxTest - get 3
18:52:39.157 [parallel-2] INFO com.example.demo.FluxTest - get 4
18:52:40.155 [parallel-2] INFO com.example.demo.FluxTest - get 5
18:52:41.154 [parallel-2] INFO com.example.demo.FluxTest - get 6
18:52:42.158 [parallel-2] INFO com.example.demo.FluxTest - get 7
18:52:43.157 [parallel-2] INFO com.example.demo.FluxTest - get 8
18:52:44.156 [parallel-2] INFO com.example.demo.FluxTest - get 9
18:52:45.154 [parallel-2] INFO com.example.demo.FluxTest - get 10
```
传统的list streams不是异步的，好比如一批500件的半成品，得在A环节都处理完，才能下一个环节B，而reactive streams之所以成为reactive，就好比如这批500件的半成品，A环节每处理完一件就可以立即推往下个环节B处理，源源不断，而不是等所有的半成品都在A环节处理再推往B环节。典型的活生生的一个生产流水线的例子。

## backpressure
这样一个生产流水线，有个要求就是每个环节的处理要能够协调，就像电影起跑线里头男主角去工厂打工，流水线花花往他那边推送货物，他速度跟不上，导致货物都掉地上了，最后不得不人工关掉流水线。 在应用程序里头，如果发布者速度过快，而订阅者速度慢，那么就会数据就会堆积，控制不好就容易产生内存溢出，而backpressure就专门用来解决这个问题的。

### pull模型的backpressure
```
@Test
    public void testPullBackpressure(){
        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription s;
                    int onNextAmount;

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.s = s;
                        s.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                        onNextAmount++;
                        if (onNextAmount % 2 == 0) {
                            s.request(2);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {}

                    @Override
                    public void onComplete() {}
                });

        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
```
### push模型的backpressure
借助线程相关的操作符，比如timeout(),delayElements(),buffer(),skip(),take()来控制数据产生速度。

#### delayElements
```
@Test
    public void testPushBackpressure() throws InterruptedException {
        Flux.range(1, 1000)
                .delayElements(Duration.ofMillis(200))
                .subscribe(e -> {
                    LOGGER.info("subscribe:{}",e);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                });
        Thread.sleep(100*1000);
    }
```
输出实例

```
19:37:00.870 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
19:37:01.117 [parallel-1] INFO com.example.demo.FluxTest - subscribe:1
19:37:03.326 [parallel-2] INFO com.example.demo.FluxTest - subscribe:2
19:37:05.535 [parallel-3] INFO com.example.demo.FluxTest - subscribe:3
19:37:07.743 [parallel-4] INFO com.example.demo.FluxTest - subscribe:4
19:37:09.953 [parallel-5] INFO com.example.demo.FluxTest - subscribe:5
19:37:12.156 [parallel-6] INFO com.example.demo.FluxTest - subscribe:6
19:37:14.363 [parallel-7] INFO com.example.demo.FluxTest - subscribe:7
19:37:16.568 [parallel-8] INFO com.example.demo.FluxTest - subscribe:8
19:37:18.775 [parallel-1] INFO com.example.demo.FluxTest - subscribe:9
```
这是个delayElements的例子，可以看到数据不丢失，但是延时是生产延时+消费延时

#### sample
```
@Test
    public void testSampleBackpressure() throws InterruptedException {
        Flux.range(1, 1000)
                .log()
                .delayElements(Duration.ofMillis(200))
                .sample(Duration.ofMillis(1000))
                .subscribe(e -> {
                    LOGGER.info("subscribe:{}",e);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                });
        Thread.sleep(100*1000);
    }
```
输出实例

```
19:48:40.516 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
19:48:40.544 [main] INFO reactor.Flux.Range.1 - | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
19:48:40.546 [main] INFO reactor.Flux.Range.1 - | onNext(1)
19:48:40.770 [parallel-2] INFO reactor.Flux.Range.1 - | onNext(2)
19:48:40.974 [parallel-3] INFO reactor.Flux.Range.1 - | onNext(3)
19:48:41.175 [parallel-4] INFO reactor.Flux.Range.1 - | onNext(4)
19:48:41.378 [parallel-5] INFO reactor.Flux.Range.1 - | onNext(5)
19:48:41.543 [parallel-1] INFO com.example.demo.FluxTest - subscribe:4
19:48:41.583 [parallel-6] INFO reactor.Flux.Range.1 - | onNext(6)
19:48:41.785 [parallel-7] INFO reactor.Flux.Range.1 - | onNext(7)
19:48:41.989 [parallel-8] INFO reactor.Flux.Range.1 - | onNext(8)
19:48:43.547 [parallel-1] INFO reactor.Flux.Range.1 - | onNext(9)
19:48:43.548 [parallel-1] INFO com.example.demo.FluxTest - subscribe:8
19:48:43.751 [parallel-2] INFO reactor.Flux.Range.1 - | onNext(10)
19:48:43.952 [parallel-3] INFO reactor.Flux.Range.1 - | onNext(11)
```
可以看到，由于订阅者速度慢，导致部分数据被丢弃

#### buffer
```
@Test
    public void testBufferBackpressure() throws InterruptedException {
        Flux.range(1, 1000)
//                .log()
                .delayElements(Duration.ofMillis(200))
                .buffer(Duration.ofMillis(800))
                .subscribe(e -> {
                    LOGGER.info("subscribe:{}",e);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                });
        Thread.sleep(100*1000);
    }
```
输出实例

```
19:55:06.680 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
19:55:06.712 [main] INFO reactor.Flux.Range.1 - | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
19:55:06.714 [main] INFO reactor.Flux.Range.1 - | onNext(1)
19:55:06.940 [parallel-2] INFO reactor.Flux.Range.1 - | onNext(2)
19:55:07.141 [parallel-3] INFO reactor.Flux.Range.1 - | onNext(3)
19:55:07.343 [parallel-4] INFO reactor.Flux.Range.1 - | onNext(4)
19:55:07.509 [parallel-1] INFO com.example.demo.FluxTest - subscribe:[1, 2, 3]
19:55:07.545 [parallel-5] INFO reactor.Flux.Range.1 - | onNext(5)
19:55:07.748 [parallel-6] INFO reactor.Flux.Range.1 - | onNext(6)
19:55:07.951 [parallel-7] INFO reactor.Flux.Range.1 - | onNext(7)
19:55:08.156 [parallel-8] INFO reactor.Flux.Range.1 - | onNext(8)
19:55:09.512 [parallel-1] INFO com.example.demo.FluxTest - subscribe:[4, 5, 6, 7]
19:55:11.515 [parallel-1] INFO reactor.Flux.Range.1 - | onNext(9)
19:55:11.516 [parallel-1] INFO com.example.demo.FluxTest - subscribe:[8]
19:55:11.719 [parallel-2] INFO reactor.Flux.Range.1 - | onNext(10)
19:55:11.923 [parallel-3] INFO reactor.Flux.Range.1 - | onNext(11)
19:55:12.127 [parallel-4] INFO reactor.Flux.Range.1 - | onNext(12)
19:55:12.330 [parallel-5] INFO reactor.Flux.Range.1 - | onNext(13)
19:55:12.533 [parallel-6] INFO reactor.Flux.Range.1 - | onNext(14)
19:55:12.735 [parallel-7] INFO reactor.Flux.Range.1 - | onNext(15)
19:55:12.941 [parallel-8] INFO reactor.Flux.Range.1 - | onNext(16)
19:55:13.516 [parallel-1] INFO com.example.demo.FluxTest - subscribe:[9, 10, 11, 12, 13, 14, 15]
19:55:15.517 [parallel-1] INFO reactor.Flux.Range.1 - | onNext(17)
19:55:15.517 [parallel-1] INFO com.example.demo.FluxTest - subscribe:[16]
19:55:15.721 [parallel-2] INFO reactor.Flux.Range.1 - | onNext(18)
19:55:15.925 [parallel-3] INFO reactor.Flux.Range.1 - | onNext(19)
19:55:16.127 [parallel-4] INFO reactor.Flux.Range.1 - | onNext(20)
19:55:16.331 [parallel-5] INFO reactor.Flux.Range.1 - | onNext(21)
19:55:16.537 [parallel-6] INFO reactor.Flux.Range.1 - | onNext(22)
19:55:16.738 [parallel-7] INFO reactor.Flux.Range.1 - | onNext(23)
19:55:16.942 [parallel-8] INFO reactor.Flux.Range.1 - | onNext(24)
19:55:17.519 [parallel-1] INFO com.example.demo.FluxTest - subscribe:[17, 18, 19, 20, 21, 22, 23]
19:55:19.522 [parallel-1] INFO reactor.Flux.Range.1 - | onNext(25)
19:55:19.522 [parallel-1] INFO com.example.demo.FluxTest - subscribe:[24]
```
将每个800ms内产生的数据堆积为一批次推送给订阅者

#### skip
```
@Test
    public void testSkip() throws InterruptedException {
        Flux.range(1, 1000)
                .log()
                .delayElements(Duration.ofMillis(200))
                .skip(Duration.ofMillis(800))
                .subscribe(e -> {
                    LOGGER.info("subscribe:{}",e);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                });
        Thread.sleep(100*1000);
    }
```
输出实例

```
20:02:07.558 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
20:02:07.606 [main] INFO reactor.Flux.Range.1 - | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
20:02:07.608 [main] INFO reactor.Flux.Range.1 - | onNext(1)
20:02:07.815 [parallel-2] INFO reactor.Flux.Range.1 - | onNext(2)
20:02:08.016 [parallel-3] INFO reactor.Flux.Range.1 - | onNext(3)
20:02:08.218 [parallel-4] INFO reactor.Flux.Range.1 - | onNext(4)
20:02:08.421 [parallel-5] INFO com.example.demo.FluxTest - subscribe:4
20:02:10.425 [parallel-5] INFO reactor.Flux.Range.1 - | onNext(5)
20:02:10.631 [parallel-6] INFO com.example.demo.FluxTest - subscribe:5
20:02:12.635 [parallel-6] INFO reactor.Flux.Range.1 - | onNext(6)
20:02:12.840 [parallel-7] INFO com.example.demo.FluxTest - subscribe:6
20:02:14.843 [parallel-7] INFO reactor.Flux.Range.1 - | onNext(7)
20:02:15.049 [parallel-8] INFO com.example.demo.FluxTest - subscribe:7
```
通过skip指定跳过最初一个时间段内产生的数据

#### take
```
@Test
    public void testTakeBackpressure() throws InterruptedException {
        Flux.range(1, 1000)
                .log()
                .delayElements(Duration.ofMillis(200))
                .take(Duration.ofMillis(4000))
                .subscribe(e -> {
                    LOGGER.info("subscribe:{}",e);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                });
        Thread.sleep(100*1000);
    }
```
输出实例

```
20:05:08.366 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
20:05:08.419 [main] INFO reactor.Flux.Range.1 - | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
20:05:08.422 [main] INFO reactor.Flux.Range.1 - | onNext(1)
20:05:08.629 [parallel-2] INFO com.example.demo.FluxTest - subscribe:1
20:05:10.633 [parallel-2] INFO reactor.Flux.Range.1 - | onNext(2)
20:05:10.835 [parallel-3] INFO com.example.demo.FluxTest - subscribe:2
20:05:12.418 [parallel-1] INFO reactor.Flux.Range.1 - | cancel()
```
通过take表示只推送前面几个或前面一段时间产生的数据给订阅者

## 小结
reactive streams对于具有多个阶段的数据处理来说，非常有用，可以节省很多时间，另外又有backpressure来控制订阅者速度过慢的问题，非常值得使用。

资料
[webflux学习路径](https://xwjie.github.io/webflux/webflux-study-path.html#java%E4%B8%ADthis%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86)