package com.yy.test;

import org.junit.Test;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/15 at 上午6:45
 */
public class KafkaTest extends AppTest{

    @Resource
    private KafkaTemplate<String, String> myKafkaTemplate;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void test(){
        kafkaTemplate.send("skyler"," i am comint");
    }

    @Test
    public void sendMessage() {
        String topicName = "topicName";
        myKafkaTemplate.send(topicName, "foo","kaka");
    }
}
