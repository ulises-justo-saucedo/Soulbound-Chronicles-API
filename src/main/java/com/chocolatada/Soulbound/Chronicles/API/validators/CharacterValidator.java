package com.chocolatada.Soulbound.Chronicles.API.validators;

import com.chocolatada.Soulbound.Chronicles.API.entities.CharacterEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidName;

public class CharacterValidator {
    private final static int MIN_ID = 1;
    private final static int MAX_NAME_LENGTH = 12;
    private final static int MIN_NAME_LENGTH = 4;

    public static void validateId(long id, CharacterEntity character) throws CharacterInvalidId {
        if(id < MIN_ID)
            throw new CharacterInvalidId("ERROR: Id '"+id+"' cannot be less than '"+MIN_ID+"'.");

        if(character == null)
            throw new CharacterInvalidId("ERROR: Id '"+id+"' doesn't correspond to any character.");
    }
    public static void validateName(String name) throws CharacterInvalidName {
        if(name.contains(" "))
            throw new CharacterInvalidName("ERROR: Name cannot contain blank spaces.");

        if(name.length() < MIN_NAME_LENGTH)
            throw new CharacterInvalidName("ERROR: Name '"+name+"' cannot be less than "+MIN_NAME_LENGTH+" characters.");

        if(name.length() > MAX_NAME_LENGTH)
            throw new CharacterInvalidName("ERROR: Name '"+name+"' cannot be longer than "+MAX_NAME_LENGTH+" characters.");

        if(name.isEmpty())
            throw new CharacterInvalidName("ERROR: Name cannot be empty.");
    }
}
