package com.yy.third_componet.kafka.spring;

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

    @KafkaListener(topics = {"skyler"})
    public void receive(String message){
        System.out.println("consumer message:" + message);
    }
}
