package com.chocolatada.Soulbound.Chronicles.API.controllers;

import com.chocolatada.Soulbound.Chronicles.API.entities.UserEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidPassword;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidUsername;
import com.chocolatada.Soulbound.Chronicles.API.services.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserServiceImpl service;
    public UserController(UserServiceImpl service) {
        this.service = service;
    }
    @PostMapping()
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) throws UserInvalidUsername, UserInvalidPassword, UserInvalidId {
        UserEntity userSaved = service.update(user);

        return new ResponseEntity<>(userSaved, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable("id") int id) throws UserInvalidId {
        UserEntity user = service.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<ArrayList<UserEntity>> getAll() {
        ArrayList<UserEntity> users = service.getAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
