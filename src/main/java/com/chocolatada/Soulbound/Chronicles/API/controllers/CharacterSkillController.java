package com.chocolatada.Soulbound.Chronicles.API.controllers;

import com.chocolatada.Soulbound.Chronicles.API.entities.character_skill.CharacterSkillEntity;
import com.chocolatada.Soulbound.Chronicles.API.entities.character_skill.CharacterSkillId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.skill.SkillInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.services.impl.CharacterSkillServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/characterskill")
public class CharacterSkillController {
    private CharacterSkillServiceImpl service;
    public CharacterSkillController(CharacterSkillServiceImpl service) {
        this.service = service;
    }
    @PostMapping()
    public ResponseEntity<CharacterSkillEntity> save(@RequestBody CharacterSkillEntity characterSkill) throws Exception {
        return new ResponseEntity<>(service.update(characterSkill), HttpStatus.OK);
    }
    @GetMapping("/{characterId}/{skillId}")
    public ResponseEntity<CharacterSkillEntity> getById(@PathVariable("characterId") Long characterId, @PathVariable("skillId") Long skillId) throws CharacterInvalidId, SkillInvalidId {
        CharacterSkillId id = new CharacterSkillId(characterId, skillId);

        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<ArrayList<CharacterSkillEntity>> getAll() {
        ArrayList<CharacterSkillEntity> characterSkillEntities = service.getAll();

        return new ResponseEntity<>(characterSkillEntities, HttpStatus.OK);
    }
}
