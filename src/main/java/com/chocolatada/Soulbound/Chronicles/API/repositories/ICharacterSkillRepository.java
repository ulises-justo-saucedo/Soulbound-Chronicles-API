package com.chocolatada.Soulbound.Chronicles.API.repositories;

import com.chocolatada.Soulbound.Chronicles.API.entities.character_skill.CharacterSkillEntity;
import com.chocolatada.Soulbound.Chronicles.API.entities.character_skill.CharacterSkillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterSkillRepository extends JpaRepository<CharacterSkillEntity, CharacterSkillId> {
}
