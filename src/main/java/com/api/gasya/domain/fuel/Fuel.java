package com.api.gasya.domain.fuel;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fuels")
@Data
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    // description text  NOT NULL,
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;
}
