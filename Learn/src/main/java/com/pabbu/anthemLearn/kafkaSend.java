package com.pabbu.anthemLearn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaSend {

    private static final Logger LOG = LoggerFactory.getLogger(kafkaSend.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("pabbu")
    private String topic;

    public void send(String message){
        LOG.info("sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}