package com.api.gasya.domain.promotion;

import com.api.gasya.domain.gasStation.GasStation;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promotions")
@Data
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;
}
