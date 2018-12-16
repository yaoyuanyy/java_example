package com.yy.message.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/15 at 上午6:50
 */
@Component
public class KafkaConsumer {

//    @KafkaListener(topics = "skyler")
//    public void receive(String message){
//        System.out.println("consumer message:" + message);
//    }
//
//    @KafkaListener(topics = "topicName", groupId = "foo")
//    public void listen(String message) {
//        System.out.println("Received Messasge in group foo: " + message);
//    }
}
