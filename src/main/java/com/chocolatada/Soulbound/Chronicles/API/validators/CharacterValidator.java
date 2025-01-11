package com.chocolatada.Soulbound.Chronicles.API.validators;

import com.chocolatada.Soulbound.Chronicles.API.entities.CharacterEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.character.CharacterInvalidName;

public class CharacterValidator {
    public static void validateId(long id, CharacterEntity character) throws CharacterInvalidId {
        if(id < 1)
            throw new CharacterInvalidId("ERROR: Id '"+id+"' cannot be less than 1.");

        if(character == null)
            throw new CharacterInvalidId("ERROR: Id '"+id+"' doesn't correspond to any character.");
    }
    public static void validateName(String name) throws CharacterInvalidName {
        if(name.contains(" "))
            throw new CharacterInvalidName("ERROR: Name cannot contain blank spaces.");

        if(name.isEmpty())
            throw new CharacterInvalidName("ERROR: Name cannot be empty.");
    }
}
