package com.apps.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MacController {

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

}
