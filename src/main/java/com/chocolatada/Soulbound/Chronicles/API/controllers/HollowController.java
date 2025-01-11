package com.chocolatada.Soulbound.Chronicles.API.controllers;

import com.chocolatada.Soulbound.Chronicles.API.entities.HollowEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidDescription;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidName;
import com.chocolatada.Soulbound.Chronicles.API.services.impl.HollowServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hollow")
public class HollowController {
    private HollowServiceImpl service;
    public HollowController(HollowServiceImpl service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<HollowEntity> save(@RequestBody HollowEntity hollow) throws HollowInvalidId, HollowInvalidName, HollowInvalidDescription {
        return new ResponseEntity<>(service.update(hollow), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HollowEntity> getById(@PathVariable("id") long id) throws HollowInvalidId {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ArrayList<HollowEntity>> getAll() {
        ArrayList<HollowEntity> hollows = service.getAll();

        return new ResponseEntity<>(hollows, HttpStatus.OK);
    }
}
