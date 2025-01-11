package com.chocolatada.Soulbound.Chronicles.API.services.impl;

import com.chocolatada.Soulbound.Chronicles.API.entities.character_skill.CharacterSkillEntity;
import com.chocolatada.Soulbound.Chronicles.API.entities.character_skill.CharacterSkillId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.skill.SkillInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.repositories.ICharacterSkillRepository;
import com.chocolatada.Soulbound.Chronicles.API.services.IBasicOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CharacterSkillServiceImpl implements IBasicOperations<CharacterSkillEntity, CharacterSkillId> {
    private ICharacterSkillRepository repository;
    private CharacterServiceImpl characterService;
    private SkillServiceImpl skillService;
    public CharacterSkillImpl(ICharacterSkillRepository repository, CharacterServiceImpl characterService, SkillServiceImpl skillService) {
        this.repository = repository;
        this.characterService = characterService;
        this.skillService = skillService;
    }

    @Override
    public CharacterSkillEntity save(CharacterSkillEntity obj) throws Exception {
        return repository.save(obj);
    }

    @Override
    public CharacterSkillEntity update(CharacterSkillEntity obj) throws CharacterInvalidId, Exception {
        CharacterSkillId id = obj.getId();

        getById(id);

        return save(obj);
    }

    @Override
    public CharacterSkillEntity getById(CharacterSkillId id) throws CharacterInvalidId, SkillInvalidId {
        if(id.getCharacterId() != null) {
            long characterId = id.getCharacterId();

            characterService.getById(characterId);
        }

        if(id.getSkillId() != null) {
            long skillId = id.getSkillId();

            skillService.getById(skillId);
        }

        return repository.getById(id);
    }

    @Override
    public ArrayList<CharacterSkillEntity> getAll() {
        return (ArrayList<CharacterSkillEntity>) repository.findAll();
    }
}
