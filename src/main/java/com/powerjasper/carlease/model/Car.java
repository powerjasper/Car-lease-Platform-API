package com.powerjasper.carlease.model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Car {
  @Schema(name = "id", example = "1")
  private Long id;

  @Schema(name = "make", example = "KIA")
  private String make;

  @Schema(name = "model", example = "RIO")
  private String model;

  @Schema(name = "version", example = "UB")
  private String version;

  @Schema(name = "nrOfDoors", example = "5")
  private Integer nrOfDoors;

  @Schema(name = "emission", example = "114")
  private BigDecimal emission;

  @Schema(name = "grossPrice", example = "10000")
  private BigDecimal grossPrice;

  @Schema(name = "netPrice", example = "10000")
  private BigDecimal netPrice;
}
