package com.chocolatada.Soulbound.Chronicles.API.validators;

import com.chocolatada.Soulbound.Chronicles.API.entities.UserEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidPassword;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidUsername;

public class UserValidator {
    public static void validateId(long id, UserEntity user) throws UserInvalidId {
        if(id < 1)
            throw new UserInvalidId("ERROR: Id '"+id+"' cannot be less than 1.");

        if(user == null)
            throw new UserInvalidId("ERROR: Id '"+id+"' doesn't correspond to any user.");
    }
    public static void validateUsername(String username) throws UserInvalidUsername {
        if(username.isEmpty())
            throw new UserInvalidUsername("ERROR: Username cannot be empty.");

        if(username.length() > 11)
            throw new UserInvalidUsername("ERROR: Username '"+username+"' cannot be longer than 11 characters.");
    }
    public static void validatePassword(String password) throws UserInvalidPassword {
        if(password.isEmpty())
            throw new UserInvalidPassword("ERROR: Password cannot be empty.");

        if(password.length() < 6)
            throw new UserInvalidPassword("ERROR: Password '"+password+"' cannot be shorter than 6 characters.");
    }
}
