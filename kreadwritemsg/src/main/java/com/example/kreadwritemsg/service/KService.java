package com.example.kreadwritemsg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public void sendDataToTopic(String topic, String msg){

        kafkaTemplate.send(topic,msg);
    }
}
