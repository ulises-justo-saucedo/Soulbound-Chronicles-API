package com.chocolatada.Soulbound.Chronicles.API.services.impl;

import com.chocolatada.Soulbound.Chronicles.API.entities.CharacterEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidName;
import com.chocolatada.Soulbound.Chronicles.API.repositories.ICharacterRepository;
import com.chocolatada.Soulbound.Chronicles.API.services.IBasicOperations;
import com.chocolatada.Soulbound.Chronicles.API.validators.CharacterValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CharacterServiceImpl implements IBasicOperations<CharacterEntity> {
    private ICharacterRepository repository;
    public CharacterServiceImpl(ICharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public CharacterEntity save(CharacterEntity obj) throws CharacterInvalidName {
        String name = obj.getName();

        CharacterValidator.validateName(name);

        obj.setExperienceLimit(obj.calculateExperienceLimit());

        return repository.save(obj);
    }

    @Override
    public CharacterEntity update(CharacterEntity obj) throws CharacterInvalidId, CharacterInvalidName {
        if(obj.getId() != null) {
            long id = obj.getId();

            getById(id);
        }
        return save(obj);
    }

    @Override
    public CharacterEntity getById(long id) throws CharacterInvalidId {
        CharacterEntity character = repository.findById(id).orElse(null);

        CharacterValidator.validateId(id, character);

        return character;
    }

    @Override
    public ArrayList<CharacterEntity> getAll() {
        return (ArrayList<CharacterEntity>) repository.findAll();
    }
}
