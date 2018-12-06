package com.yy.message.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/12/6 at 上午8:13
 */
@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaProperties properties;

    @Bean
    public ProducerFactory<String, String> producerFactory() {

        properties.getProducer().setKeySerializer(StringSerializer.class);
        properties.getProducer().setValueSerializer(StringSerializer.class);
        DefaultKafkaProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(properties.buildProducerProperties());
        return producerFactory;
    }

    @Bean
    public KafkaTemplate<String, String> myKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
