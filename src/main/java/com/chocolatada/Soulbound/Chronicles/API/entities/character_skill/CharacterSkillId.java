package com.chocolatada.Soulbound.Chronicles.API.entities.character_skill;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterSkillId implements Serializable {
    private Long characterId;
    private Long skillId;
}
