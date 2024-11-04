package org.hallogame.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Component
@Data
@Scope("prototype")
@Entity
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String skill;
    @Column(nullable = false)
    private int damage;
    @Column(length = 100, nullable = false)
    private String weakness;
    @Column(length = 20, nullable = false)
    private String type;
    @Column(nullable = false)
    private int strength;
    @Column(nullable = false)
    private int intelligence;
    private String description;
}
