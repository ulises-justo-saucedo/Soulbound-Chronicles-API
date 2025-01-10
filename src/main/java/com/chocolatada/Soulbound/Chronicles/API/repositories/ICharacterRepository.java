package com.chocolatada.Soulbound.Chronicles.API.repositories;

import com.chocolatada.Soulbound.Chronicles.API.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepository extends JpaRepository<CharacterEntity, Long> {
}
