package com.pervishkond.hibernateshawarmamenu.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("woman")
public class Women extends TopSales {

    @Column(name = "visit_hours", nullable = true)
    private Integer visitHours;
}
