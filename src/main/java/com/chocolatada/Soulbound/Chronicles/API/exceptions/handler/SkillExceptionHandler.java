package com.chocolatada.Soulbound.Chronicles.API.exceptions.handler;

import com.chocolatada.Soulbound.Chronicles.API.exceptions.skill.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SkillExceptionHandler {
    @ExceptionHandler(SkillInvalidId.class)
    public ResponseEntity<String> invalidId(SkillInvalidId e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SkillInvalidType.class)
    public ResponseEntity<String> invalidType(SkillInvalidType e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SkillInvalidClassType.class)
    public ResponseEntity<String> invalidClassType(SkillInvalidClassType e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SkillInvalidName.class)
    public ResponseEntity<String> invalidName(SkillInvalidName e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SkillInvalidModifier.class)
    public ResponseEntity<String> invalidModifier(SkillInvalidModifier e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
}
