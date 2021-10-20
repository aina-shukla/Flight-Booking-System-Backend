package com.adminService.Service;

import com.adminService.models.AdminEntity;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerDemo {
    
    @KafkaListener(topics = "kafka_topic_name", groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeData(AdminEntity book){
        System.out.println("Consumer app has received data+++++");
        System.out.println(book);
    }

}