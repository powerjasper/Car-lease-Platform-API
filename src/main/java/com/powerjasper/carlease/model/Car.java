package com.powerjasper.carlease.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Car {
  private Long id;
  private String make;
  private String model;
  private String version;
  private Integer nrOfDoors;
  private BigDecimal emission;
  private BigDecimal grossPrice;
  private BigDecimal netPrice;
}
