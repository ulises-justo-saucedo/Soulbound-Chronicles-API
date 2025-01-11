package com.chocolatada.Soulbound.Chronicles.API.controllers;

import com.chocolatada.Soulbound.Chronicles.API.entities.SkillEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.skill.*;
import com.chocolatada.Soulbound.Chronicles.API.services.impl.SkillServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/skill")
public class SkillController {
    private SkillServiceImpl service;
    public SkillController(SkillServiceImpl service) {
        this.service = service;
    }
    @PostMapping()
    public ResponseEntity<SkillEntity> save(@RequestBody SkillEntity skill) throws SkillInvalidName, SkillInvalidModifier, SkillInvalidType, SkillInvalidId, SkillInvalidClassType {
        return new ResponseEntity<>(service.update(skill), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SkillEntity> getById(@PathVariable("id") long id) throws SkillInvalidId {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<ArrayList<SkillEntity>> getAll() {
        ArrayList<SkillEntity> skills = service.getAll();

        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
}
