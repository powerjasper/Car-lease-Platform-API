package com.powerjasper.carlease.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Customer {
  private Long id;
  private String name;
  private String street;
  private String houseNumber;
  private String zipCode;
  private String place;
  private String emailAddress;
  private String phoneNumber;
}
