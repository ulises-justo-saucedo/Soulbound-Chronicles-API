package com.chocolatada.Soulbound.Chronicles.API.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivingBeing {
    protected String aspect;
    protected int health;
    protected int attack;
    protected int defense;
    protected int reiatsu;
    protected int level;
    protected int experience;
}
