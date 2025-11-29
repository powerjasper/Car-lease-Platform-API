package com.powerjasper.carlease.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LeaseRateResponse {
    @Schema(name = "leaseRate", description = "Calculated lease rate per month in euros", example = "200,25")
    private BigDecimal leaseRate;
}
