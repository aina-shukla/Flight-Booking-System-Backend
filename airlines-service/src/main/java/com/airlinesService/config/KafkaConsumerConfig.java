package com.airlinesService.config;

import java.util.HashMap;
import java.util.Map;

import com.airlinesService.Entity.AirlinesEntity;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.MessageHeaders;

@Configuration
@EnableKafka
public class KafkaConsumerConfig<NTCMessageBody> {

	private ListenerExecutionFailedException listen3Exception;

	@Bean
    public ConsumerFactory<String, AirlinesEntity> userConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, ErrorHandlingDeserializer.class);
        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, ErrorHandlingDeserializer.class);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.core.model.ServiceMsgDTO");
        config.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,false);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
        config.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 300000);
        config.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10000);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new ErrorHandlingDeserializer(new JsonDeserializer(AirlinesEntity.class)));    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AirlinesEntity> userKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AirlinesEntity> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }
    
    @Bean
    public ConsumerAwareListenerErrorHandler listen3ErrorHandler() {
    return (m, e, c) -> {
        this.listen3Exception = e;
        MessageHeaders headers = m.getHeaders();
        c.seek(new org.apache.kafka.common.TopicPartition(
                headers.get(KafkaHeaders.RECEIVED_TOPIC, String.class),
                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class)),
                headers.get(KafkaHeaders.OFFSET, Long.class));
        return null;
       };
    }
}