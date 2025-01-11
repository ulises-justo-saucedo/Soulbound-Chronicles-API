package com.chocolatada.Soulbound.Chronicles.API.exceptions.handler;

import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CharacterExceptionHandler {
    @ExceptionHandler(CharacterInvalidId.class)
    public ResponseEntity<String> invalidId(CharacterInvalidId e) {
        return response(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CharacterInvalidName.class)
    public ResponseEntity<String> invalidName(CharacterInvalidName e) {
        return response(e, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> response(Exception e, HttpStatus status) {
        return new ResponseEntity<>(e.getMessage(), status);
    }
}
