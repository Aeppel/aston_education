package com.pervishkond.hibernateshawarmamenu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shawarma_menu", schema = "public", catalog = "test_db")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @Column(name = "shawarma_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "shawarma_name")
    private String shawarmaName;
    
    private Integer price;

@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "composition_of_the_product",
            joinColumns = @JoinColumn(name = "shawarma_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
    private List<Ingredients> ingredients;
}
