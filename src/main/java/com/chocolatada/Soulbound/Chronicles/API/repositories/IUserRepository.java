package com.chocolatada.Soulbound.Chronicles.API.repositories;

import com.chocolatada.Soulbound.Chronicles.API.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
