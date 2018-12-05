package com.yy.message.kafka.proto;


import java.io.IOException;
import java.util.Properties;

import com.yy.util.PropertyUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/14 at 下午5:45
 */
public class KafkaProducerDemo {

    private int total = 1000000;

    public void send(){

        long start = System.currentTimeMillis();
        System.out.println("Kafka Producer send msg start,total msgs:"+total);

        // set up the producer
        Producer<String, String> producer = null;
        try {
            Properties props = PropertyUtils.load("producer_config.properties");
            producer = new KafkaProducer<>(props);

            for (int i = 0; i < total; i++){
                producer.send(new ProducerRecord<String, String>("hello",
                        String.valueOf(i), String.format("{\"type\":\"test\", \"t\":%d, \"k\":%d}", System.currentTimeMillis(), i)));

                // every so often send to a different topic
                if (i % 1000 == 0) {
                    producer.send(new ProducerRecord<String, String>("test", String.format("{\"type\":\"marker\", \"t\":%d, \"k\":%d}", System.currentTimeMillis(), i)));
                    producer.send(new ProducerRecord<String, String>("hello", String.format("{\"type\":\"marker\", \"t\":%d, \"k\":%d}", System.currentTimeMillis(), i)));

                    producer.flush();
                    System.out.println("Sent msg number " + i);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            producer.close();
        }

        System.out.println("Kafka Producer send msg over,cost time:"+(System.currentTimeMillis()-start)+"ms");
    }
}
