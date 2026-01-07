package com.apps.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.kafka.topic}")
    private String topicName;

    /*public void sendMessage(String message) {
        log.info("Producing message: {}", message);
        kafkaTemplate.send(topicName, message);
    }*/

    public void sendMessage(String message) {
        kafkaTemplate.send("test-topic", message).whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Success! Sent to offset: " + result.getRecordMetadata().offset());
            } else {
                System.err.println("Failed to send message: " + ex.getMessage());
            }
        });
    }
}