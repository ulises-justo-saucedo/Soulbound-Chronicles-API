package com.chocolatada.Soulbound.Chronicles.API.repositories;

import com.chocolatada.Soulbound.Chronicles.API.entities.HollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHollowRepository extends JpaRepository<HollowEntity, Long> {
}
