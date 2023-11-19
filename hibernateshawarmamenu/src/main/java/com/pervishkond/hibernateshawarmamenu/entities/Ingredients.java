package com.pervishkond.hibernateshawarmamenu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "ingredients", schema = "public", catalog = "test_db")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ingredients_id", nullable = false)
    private Integer id;
    private String ingredients;


}