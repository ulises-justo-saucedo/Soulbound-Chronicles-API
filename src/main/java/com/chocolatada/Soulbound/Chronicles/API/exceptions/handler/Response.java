package com.chocolatada.Soulbound.Chronicles.API.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static ResponseEntity<String> send(Exception e, HttpStatus status) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), status);
    }
}
