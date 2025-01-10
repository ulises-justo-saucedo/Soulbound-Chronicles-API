package com.chocolatada.Soulbound.Chronicles.API.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "characters")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CharacterEntity extends LivingBeing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int experienceLimit;

    public CharacterEntity(String aspect, int health, int attack, int defense, int reiatsu, int level, int experience, String name) {
        super(aspect, health, attack, defense, reiatsu, level, experience);
        this.name = name;
        this.experienceLimit = calculateExperienceLimit();
    }

    public int calculateExperienceLimit() {
        return (int) (5 * Math.pow(this.level, 3));
    }
}
