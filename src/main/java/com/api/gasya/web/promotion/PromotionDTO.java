package com.api.gasya.web.promotion;

import lombok.Data;

@Data
public class PromotionDTO {

    private String title;
    private String description;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
}
