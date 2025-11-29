package com.powerjasper.carlease.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class LeaseRateRequest {

  @Schema(name = "mileage", description = "Mileage per year in kilometer", example = "20000")
  private Integer mileage;

  @Schema(name = "duration", description = "Duration of contract in months", example = "24")
  private Integer duration;

  @Schema(name = "interestRate", description = "Interest rate at start date", example = "3.14")
  private BigDecimal interestRate;

  @Schema(name = "netPrice", description = "Nett price of the vehicle", example = "2000.00")
  private BigDecimal netPrice;
}
