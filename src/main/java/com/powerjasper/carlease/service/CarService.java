package com.powerjasper.carlease.service;

import com.powerjasper.carlease.entity.CarEntity;
import com.powerjasper.carlease.mapper.CarMapper;
import com.powerjasper.carlease.model.Car;
import com.powerjasper.carlease.repository.CarRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;

  public List<Car> getAllCars() {
    return carRepository.findAll().stream().map(CarMapper::toDto).toList();
  }

  public Car getById(Long id) {
    CarEntity car =
        carRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
    return CarMapper.toDto(car);
  }

  public void deleteById(Long id) {
    carRepository.deleteById(id);
  }

  public Car updateById(Long id, Car car) {
    CarEntity existingCar =
        carRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
    existingCar.setMake(car.getMake());
    existingCar.setModel(car.getModel());
    existingCar.setVersion(car.getVersion());
    existingCar.setNrOfDoors(car.getNrOfDoors());
    existingCar.setEmission(car.getEmission());
    existingCar.setGrossPrice(car.getGrossPrice());
    existingCar.setNetPrice(car.getNetPrice());

    CarEntity savedCar = carRepository.save(existingCar);
    return CarMapper.toDto(savedCar);
  }
}
