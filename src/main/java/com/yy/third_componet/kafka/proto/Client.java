package com.yy.third_componet.kafka.proto;

/**
 * Description:
 * <p></p>
 * <pre>
 *     参考: https://www.jianshu.com/p/b119b1980c16
 *
 *     https://yq.aliyun.com/articles/66676?utm_campaign=wenzhang&utm_medium=article&utm_source=QQ-qun&utm_content=m_8502
 *     https://www.imooc.com/article/29943
 *     https://blog.csdn.net/shangmingtao/article/details/79567921
 * </pre>
 * NB.
 * Created by skyler on 2018/6/14 at 下午5:55
 */
public class Client {

    public static void main(String[] args) {


        KafkaProducerDemo producerDemo = new KafkaProducerDemo();
        producerDemo.send();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        KafkaConsumerDemo consumerDemo = new KafkaConsumerDemo();
        consumerDemo.consume();
    }
}
