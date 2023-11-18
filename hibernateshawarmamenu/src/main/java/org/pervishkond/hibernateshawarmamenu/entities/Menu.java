package org.pervishkond.hibernateshawarmamenu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String shawarmaName;
    
    private Integer price;
}
