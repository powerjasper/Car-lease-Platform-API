package com.powerjasper.carlease.repository;

import com.powerjasper.carlease.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {}
