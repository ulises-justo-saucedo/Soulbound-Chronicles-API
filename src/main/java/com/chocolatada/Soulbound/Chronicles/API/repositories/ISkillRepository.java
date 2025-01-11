package com.chocolatada.Soulbound.Chronicles.API.repositories;

import com.chocolatada.Soulbound.Chronicles.API.entities.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<SkillEntity, Long> {
}
