package com.chocolatada.Soulbound.Chronicles.API.services.impl;

import com.chocolatada.Soulbound.Chronicles.API.entities.HollowEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidDescription;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidName;
import com.chocolatada.Soulbound.Chronicles.API.repositories.IHollowRepository;
import com.chocolatada.Soulbound.Chronicles.API.services.IBasicOperations;
import com.chocolatada.Soulbound.Chronicles.API.validators.HollowValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HollowServiceImpl implements IBasicOperations<HollowEntity, Long> {
    private IHollowRepository repository;
    public HollowServiceImpl(IHollowRepository repository) {
        this.repository = repository;
    }

    @Override
    public HollowEntity save(HollowEntity obj) throws HollowInvalidName, HollowInvalidDescription {
        String name = obj.getName();
        String description = obj.getDescription();

        HollowValidator.validateName(name);
        HollowValidator.validateDescription(description);

        return repository.save(obj);
    }

    @Override
    public HollowEntity update(HollowEntity obj) throws HollowInvalidName, HollowInvalidDescription, HollowInvalidId {
        if(obj.getId() != null) {
            long id = obj.getId();

            getById(id);
        }

        return save(obj);
    }

    @Override
    public HollowEntity getById(Long id) throws HollowInvalidId {
        HollowEntity hollow = repository.findById(id).orElse(null);

        HollowValidator.validateId(id, hollow);

        return hollow;
    }

    @Override
    public ArrayList<HollowEntity> getAll() {
        return (ArrayList<HollowEntity>) repository.findAll();
    }
}
