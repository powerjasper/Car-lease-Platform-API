package com.powerjasper.carlease.repository;

import com.powerjasper.carlease.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {}
