package com.chocolatada.Soulbound.Chronicles.API.validators;

import com.chocolatada.Soulbound.Chronicles.API.entities.HollowEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidDescription;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidId;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.hollow.HollowInvalidName;

public class HollowValidator {
    private static final int MIN_ID_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_DESCRIPTION_LENGTH = 254;

    public static void validateId(Long id, HollowEntity hollow) throws HollowInvalidId {
        if(id < MIN_ID_LENGTH)
            throw new HollowInvalidId("ERROR: Id '"+id+"' cannot be less than '"+MIN_ID_LENGTH+"'.");

        if(hollow == null)
            throw new HollowInvalidId("ERROR: Id '"+id+"' doesn't correspond to any hollow.");
    }
    public static void validateName(String name) throws HollowInvalidName {
        if(name.isEmpty())
            throw new HollowInvalidName("ERROR: Name cannot be empty.");

        if(name.length() > MAX_NAME_LENGTH)
            throw new HollowInvalidName("ERROR: Name cannot be longer than '"+MAX_NAME_LENGTH+"' characters.");
    }
    public static void validateDescription(String description) throws HollowInvalidDescription {
        if(description.isEmpty())
            throw new HollowInvalidDescription("ERROR: Description cannot be empty.");

        if(description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new HollowInvalidDescription("ERROR: Description cannot be longer than '"+MAX_DESCRIPTION_LENGTH+"' characters.");
        }
    }
}
