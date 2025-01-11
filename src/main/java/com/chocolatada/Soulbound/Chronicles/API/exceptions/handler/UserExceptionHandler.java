package com.chocolatada.Soulbound.Chronicles.API.exceptions.handler;

import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidPassword;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidUsername;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserInvalidId.class)
    public ResponseEntity<String> invalidId(UserInvalidId e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserInvalidUsername.class)
    public ResponseEntity<String> invalidUsername(UserInvalidUsername e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserInvalidPassword.class)
    public ResponseEntity<String> invalidPassword(UserInvalidPassword e) {
        return Response.send(e, HttpStatus.BAD_REQUEST);
    }
}
