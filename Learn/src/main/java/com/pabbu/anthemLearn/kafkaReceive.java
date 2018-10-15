package com.pabbu.anthemLearn;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class kafkaReceive {


    @KafkaListener(topics = "pabbu")
    public void listen(@Payload String message) {
        System.out.println("received message='{}'"+ message);
    }

}