package com.example.kreadwritemsg.controller;

import com.example.kreadwritemsg.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KController {

    private static final String TOPIC = "codespotify-topic"; // Tên của Kafka topic

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/publish")
    public String sendMessageToKafka(@RequestBody String message) {
        try {
            LogService.createLogs(message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Message sent to Kafka: " + message;
    }
}
