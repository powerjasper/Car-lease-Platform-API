package com.powerjasper.carlease.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String street;

  @Column(nullable = false)
  private String houseNumber;

  @Column(nullable = false)
  private String zipCode;

  @Column(nullable = false)
  private String place;

  @Column(nullable = false)
  private String emailAddress;

  @Column(nullable = false)
  private String phoneNumber;
}
