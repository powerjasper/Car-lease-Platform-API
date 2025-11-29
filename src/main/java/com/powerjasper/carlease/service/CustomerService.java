package com.powerjasper.carlease.service;

import com.powerjasper.carlease.entity.CustomerEntity;
import com.powerjasper.carlease.mapper.CustomerMapper;
import com.powerjasper.carlease.model.Customer;
import com.powerjasper.carlease.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll().stream().map(CustomerMapper::toDto).toList();
  }

  public Customer getById(Long id) {
    CustomerEntity customer =
        customerRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    return CustomerMapper.toDto(customer);
  }

  public void deleteById(Long id) {
    customerRepository.deleteById(id);
  }

  public Customer updateById(Long id, Customer customer) {
    CustomerEntity existingCustomer =
        customerRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    existingCustomer.setName(customer.getName());
    existingCustomer.setStreet(customer.getStreet());
    existingCustomer.setHouseNumber(customer.getHouseNumber());
    existingCustomer.setZipCode(customer.getZipCode());
    existingCustomer.setPlace(customer.getPlace());
    existingCustomer.setEmailAddress(customer.getEmailAddress());
    existingCustomer.setPhoneNumber(customer.getPhoneNumber());

    CustomerEntity savedCustomer = customerRepository.save(existingCustomer);
    return CustomerMapper.toDto(savedCustomer);
  }
}
