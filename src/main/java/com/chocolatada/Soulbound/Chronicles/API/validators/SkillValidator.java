package com.chocolatada.Soulbound.Chronicles.API.validators;

import com.chocolatada.Soulbound.Chronicles.API.entities.SkillEntity;
import com.chocolatada.Soulbound.Chronicles.API.exceptions.skill.*;

public class SkillValidator {
    private static final int MIN_ID = 1;
    private static final int MAX_NAME_LENGTH = 254;
    private static final int MAX_TYPE_LENGTH = 254;
    private static final int MAX_CLASS_TYPE_LENGTH = 254;
    private static final float MIN_MODIFIER = 0.0f;
    public static void validateId(long id, SkillEntity skill) throws SkillInvalidId {
        if (id < MIN_ID) {
            throw new SkillInvalidId("ERROR: Id '"+id+"' cannot be less than "+MIN_ID);
        }

        if(skill == null)
            throw new SkillInvalidId("ERROR: Id '"+id+"' doesn't correspond to any skill.");
    }
    public static void validateName(String name) throws SkillInvalidName {
        if(name.isEmpty())
            throw new SkillInvalidName("ERROR: Name cannot be empty.");

        if(name.length() > MAX_NAME_LENGTH)
            throw new SkillInvalidName("ERROR: Name cannot be longer than '"+MAX_NAME_LENGTH+"' characters.");
    }
    public static void validateType(String type) throws SkillInvalidType {
        if(type.isEmpty())
            throw new SkillInvalidType("ERROR: Type cannot be empty.");

        if(type.length() > MAX_TYPE_LENGTH)
            throw new SkillInvalidType("ERROR: Type cannot be longer than '"+MAX_TYPE_LENGTH+"' characters.");
    }
    public static void validateClassType(String classType) throws SkillInvalidClassType {
        if(classType.isEmpty())
            throw new SkillInvalidClassType("ERROR: ClassType cannot be empty.");

        if(classType.length() > MAX_CLASS_TYPE_LENGTH)
            throw new SkillInvalidClassType("ERROR: ClassType cannot be longer than '"+MAX_CLASS_TYPE_LENGTH+"' characters.");
    }
    public static void validateModifier(float modifier) throws SkillInvalidModifier {
        if(modifier < MIN_MODIFIER)
            throw new SkillInvalidModifier("ERROR: Modifier cannot be less than '"+MIN_MODIFIER+"'.");
    }
}
