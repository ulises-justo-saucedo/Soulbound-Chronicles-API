package com.chocolatada.Soulbound.Chronicles.API.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToOne
    private CharacterEntity character;

    public UserEntity(String username, String password, CharacterEntity character) {
        this.username = username;
        this.password = password;
        this.character = character;
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
