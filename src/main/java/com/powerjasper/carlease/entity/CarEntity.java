package com.powerjasper.carlease.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String make;

  @Column(nullable = false)
  private String model;

  @Column(nullable = false)
  private String version;

  @Column(nullable = false)
  private Integer nrOfDoors;

  @Column(nullable = false)
  private BigDecimal emission;

  @Column(nullable = false)
  private BigDecimal grossPrice;

  @Column(nullable = false)
  private BigDecimal netPrice;

}
