package com.api.gasya.domain.gasStation;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "gas_stations")
@Data
public class GasStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
