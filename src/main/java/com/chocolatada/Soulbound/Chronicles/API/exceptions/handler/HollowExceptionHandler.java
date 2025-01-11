package com.chocolatada.Soulbound.Chronicles.API.exceptions.handler;

import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidDescription;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HollowExceptionHandler {
    @ExceptionHandler(HollowInvalidId.class)
    public ResponseEntity<String> invalidId(HollowInvalidId e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HollowInvalidName.class)
    public ResponseEntity<String> invalidName(HollowInvalidName e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HollowInvalidDescription.class)
    public ResponseEntity<String> invalidDescription(HollowInvalidDescription e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
}
