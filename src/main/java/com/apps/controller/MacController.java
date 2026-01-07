package com.apps.controller;

import com.apps.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class MacController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping
    public ResponseEntity<?> msg() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<String>("hello, mac.", headers, HttpStatus.OK);
    }

    @GetMapping("/api/mac")
    public ResponseEntity<?> app() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<String>("this is mac app.", headers, HttpStatus.OK);
    }

    @GetMapping("/api/push")
    public ResponseEntity<?> sendMessage() {
        String msg = "push message - .  " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy  hh:mm:ss:SSS a"));
        messageProducer.sendMessage(msg);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    }

}
