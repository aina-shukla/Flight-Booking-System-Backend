package com.airlinesService.Controller;

import com.airlinesService.models.Airlines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, Airlines> kafkaTemplate;
    
    private static final String TOPIC_NAME = "kafka_topic_name";
    
    // http://localhost:8081/publish
    @GetMapping("/adminsearch")
    public String publishMessage(@PathVariable String title){

    	Airlines b = new Airlines();

        // save data on kafka
        kafkaTemplate.send(TOPIC_NAME, b);

        return "Proccessed...";
    }

}