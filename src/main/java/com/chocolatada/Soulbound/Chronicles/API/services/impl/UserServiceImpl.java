package com.chocolatada.Soulbound.Chronicles.API.services.impl;

import com.chocolatada.Soulbound.Chronicles.API.entities.UserEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidPassword;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidUsername;
import com.chocolatada.Soulbound.Chronicles.API.repositories.IUserRepository;
import com.chocolatada.Soulbound.Chronicles.API.services.IBasicOperations;
import com.chocolatada.Soulbound.Chronicles.API.validators.UserValidator;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements IBasicOperations<UserEntity> {
    private IUserRepository repository;
    public UserServiceImpl(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserEntity save(UserEntity obj) throws UserInvalidUsername, UserInvalidPassword {
        String username = obj.getUsername();
        String password = obj.getPassword();

        UserValidator.validateUsername(username);
        UserValidator.validatePassword(password);

        return repository.save(obj);
    }

    @Override
    public UserEntity update(UserEntity obj) throws UserInvalidId, UserInvalidUsername, UserInvalidPassword {
        if(obj.getId() != null) {
            long id = obj.getId();

            getById(id);
        }

        return save(obj);
    }

    @Override
    public UserEntity getById(long id) throws UserInvalidId {
        UserEntity user = repository.findById(id).orElse(null);

        UserValidator.validateId(id, user);

        return user;
    }

    @Override
    public ArrayList<UserEntity> getAll() {
        return (ArrayList<UserEntity>) repository.findAll();
    }
}
