package com.chocolatada.Soulbound.Chronicles.API.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skills")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String classType;
    private float modifier;
    public SkillEntity(String name, String type, String classType, float modifier) {
        this.name = name;
        this.type = type;
        this.classType = classType;
        this.modifier = modifier;
    }
}
