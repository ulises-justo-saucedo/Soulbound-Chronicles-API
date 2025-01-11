package com.chocolatada.Soulbound.Chronicles.API.validators;

import com.chocolatada.Soulbound.Chronicles.API.entities.UserEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidPassword;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.user.UserInvalidUsername;

public class UserValidator {
    private final static int MIN_ID = 1;
    private final static int MAX_USERNAME_LENGTH = 12;
    private final static int MIN_USERNAME_LENGTH = 4;
    private final static int MIN_PASSWORD_LENGTH = 6;

    public static void validateId(long id, UserEntity user) throws UserInvalidId {
        if(id < MIN_ID)
            throw new UserInvalidId("ERROR: Id '"+id+"' cannot be less than '"+MIN_ID+"'.");

        if(user == null)
            throw new UserInvalidId("ERROR: Id '"+id+"' doesn't correspond to any user.");
    }
    public static void validateUsername(String username) throws UserInvalidUsername {
        if(username.isEmpty())
            throw new UserInvalidUsername("ERROR: Username cannot be empty.");

        if(username.length() < MIN_USERNAME_LENGTH)
            throw new UserInvalidUsername("ERROR: Username '"+username+"' cannot be shorter than '"+MIN_USERNAME_LENGTH+"' characters.");

        if(username.length() > MAX_USERNAME_LENGTH)
            throw new UserInvalidUsername("ERROR: Username '"+username+"' cannot be longer than '"+MAX_USERNAME_LENGTH+"' characters.");
    }
    public static void validatePassword(String password) throws UserInvalidPassword {
        if(password.isEmpty())
            throw new UserInvalidPassword("ERROR: Password cannot be empty.");

        if(password.length() < MIN_PASSWORD_LENGTH)
            throw new UserInvalidPassword("ERROR: Password cannot be shorter than '"+MIN_PASSWORD_LENGTH+"' characters.");
    }
}
