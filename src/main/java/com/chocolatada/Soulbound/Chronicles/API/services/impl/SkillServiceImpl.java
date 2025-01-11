package com.chocolatada.Soulbound.Chronicles.API.services.impl;

import com.chocolatada.Soulbound.Chronicles.API.entities.SkillEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.skill.*;
import com.chocolatada.Soulbound.Chronicles.API.repositories.ISkillRepository;
import com.chocolatada.Soulbound.Chronicles.API.services.IBasicOperations;
import com.chocolatada.Soulbound.Chronicles.API.validators.SkillValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SkillServiceImpl implements IBasicOperations<SkillEntity, Long> {
    private ISkillRepository repository;
    public SkillServiceImpl(ISkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillEntity save(SkillEntity obj) throws SkillInvalidName, SkillInvalidType, SkillInvalidClassType , SkillInvalidModifier {
        String name = obj.getName();
        String type = obj.getType();
        String classType = obj.getClassType();
        float modifier = obj.getModifier();

        SkillValidator.validateName(name);
        SkillValidator.validateType(type);
        SkillValidator.validateClassType(classType);
        SkillValidator.validateModifier(modifier);

        return repository.save(obj);
    }

    @Override
    public SkillEntity update(SkillEntity obj) throws SkillInvalidName, SkillInvalidModifier, SkillInvalidType, SkillInvalidClassType, SkillInvalidId {
        if(obj.getId() != null) {
            long id = obj.getId();

            getById(id);
        }

        return save(obj);
    }

    @Override
    public SkillEntity getById(Long id) throws SkillInvalidId {
        SkillEntity skill = repository.findById(id).orElse(null);

        SkillValidator.validateId(id, skill);

        return skill;
    }

    @Override
    public ArrayList<SkillEntity> getAll() {
        return (ArrayList<SkillEntity>) repository.findAll();
    }
}
