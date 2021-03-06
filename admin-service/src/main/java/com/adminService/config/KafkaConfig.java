package com.adminService.config;

import java.util.HashMap;
import java.util.Map;

import com.adminService.Entity.AirlinesEntity;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String,  AirlinesEntity> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.core.model.ServiceMsgDTO");
        config.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,false);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);
        return new DefaultKafkaProducerFactory<String, AirlinesEntity>(config);
    }

    @Bean
    public KafkaTemplate<String, AirlinesEntity> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}