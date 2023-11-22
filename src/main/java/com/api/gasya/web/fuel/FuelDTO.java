package com.api.gasya.web.fuel;

import lombok.Data;

@Data
public class FuelDTO {

    private String type;
    private String description;
    private Double price;
}