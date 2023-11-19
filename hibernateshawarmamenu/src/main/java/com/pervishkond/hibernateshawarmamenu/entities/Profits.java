package com.pervishkond.hibernateshawarmamenu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "profits", schema = "public", catalog = "test_db")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profits {
    @Id
    @Column(name = "shawarma_id", nullable = false)
    private Integer id;
    @Column(name = "amount_of_order", nullable = true)
    private Integer order;
    private Integer profit;
}