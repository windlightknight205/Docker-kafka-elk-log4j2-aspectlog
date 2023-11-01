//package com.example.kreadwritemsg.consumer;
//
//import com.example.kreadwritemsg.model.Content;
//import com.example.kreadwritemsg.service.KService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KListener {
//    @Autowired
//    KService service;
//
//    @KafkaListener(topics = "codespotify-topic",
//            groupId = "group_id",
//            containerFactory = "myConsumerFactory")
//    public void consume(String msg) throws JsonProcessingException {
//
//        System.out.println(msg);
//        ObjectMapper mapper = new ObjectMapper();
//
//        Content topicData = mapper.readValue(msg,Content.class);
//        if (topicData.getAge() < 18) {
//            service.sendDataToTopic("kidTopic", topicData.getMessage());
//        } else {
//            service.sendDataToTopic("adultTopic", topicData.getMessage());
//        }
//    }
//
//}
