package com.powerjasper.carlease.mapper;

import com.powerjasper.carlease.entity.CustomerEntity;
import com.powerjasper.carlease.model.Customer;

public class CustomerMapper {
  public static Customer toDto(CustomerEntity entity) {
    final Customer customer = new Customer();
    customer.setId(entity.getId());
    customer.setName(entity.getName());
    customer.setStreet(entity.getStreet());
    customer.setHouseNumber(entity.getHouseNumber());
    customer.setZipCode(entity.getZipCode());
    customer.setPlace(entity.getPlace());
    customer.setEmailAddress(entity.getEmailAddress());
    customer.setPhoneNumber(entity.getPhoneNumber());
    return customer;
  }

  public static CustomerEntity toEntity(Customer dto) {
    return CustomerEntity.builder()
        .id(dto.getId())
        .name(dto.getName())
        .street(dto.getStreet())
        .houseNumber(dto.getHouseNumber())
        .zipCode(dto.getZipCode())
        .place(dto.getPlace())
        .emailAddress(dto.getEmailAddress())
        .phoneNumber(dto.getPhoneNumber())
        .build();
  }
}
