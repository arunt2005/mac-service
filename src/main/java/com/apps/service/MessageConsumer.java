package com.apps.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumer {

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "mac-group")
    public void consume(String message) {
        log.info("Consumed message: {}", message);
    }
}