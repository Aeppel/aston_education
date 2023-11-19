package com.pervishkond.hibernateshawarmamenu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "composition_of_the_product", schema = "public", catalog = "test_db")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompositionOfTheProduct {
    @Id
    @Basic
    @Column(name = "shawarma_id", nullable = false)
    private Integer shawarmaId;
    @Basic
    @Column(name = "ingredients_id", nullable = false)
    private Integer ingredientsId;



    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "composition_of_the_product",
            joinColumns = @JoinColumn(name = "ingredients_id"),
            inverseJoinColumns = @JoinColumn(name = "shawarma_id"))
    private List<Menu> menu;

}
