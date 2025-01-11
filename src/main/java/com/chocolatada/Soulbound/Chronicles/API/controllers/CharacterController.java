package com.chocolatada.Soulbound.Chronicles.API.controllers;

import com.chocolatada.Soulbound.Chronicles.API.entities.CharacterEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidName;
import com.chocolatada.Soulbound.Chronicles.API.services.impl.CharacterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private CharacterServiceImpl service;
    public CharacterController(CharacterServiceImpl service) {
        this.service = service;
    }
    @PostMapping()
    public ResponseEntity<CharacterEntity> save(@RequestBody CharacterEntity character) throws CharacterInvalidId, CharacterInvalidName {
        return new ResponseEntity<>(service.update(character), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CharacterEntity> getById(@PathVariable("id") long id) throws CharacterInvalidId {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<ArrayList<CharacterEntity>> getAll() {
        ArrayList<CharacterEntity> characters = service.getAll();

        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
