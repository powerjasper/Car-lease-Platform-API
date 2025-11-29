package com.powerjasper.carlease.mapper;

import com.powerjasper.carlease.entity.CarEntity;
import com.powerjasper.carlease.model.Car;

public class CarMapper {
  public static Car toDto(CarEntity entity) {
    final Car car = new Car();
    car.setId(entity.getId());
    car.setMake(entity.getMake());
    car.setModel(entity.getModel());
    car.setVersion(entity.getVersion());
    car.setNrOfDoors(entity.getNrOfDoors());
    car.setEmission(entity.getEmission());
    car.setGrossPrice(entity.getGrossPrice());
    car.setNetPrice(entity.getNetPrice());
    return car;
  }

  public static CarEntity toEntity(Car car) {
    return CarEntity.builder()
        .id(car.getId())
        .make(car.getMake())
        .model(car.getModel())
        .version(car.getVersion())
        .nrOfDoors(car.getNrOfDoors())
        .emission(car.getEmission())
        .grossPrice(car.getGrossPrice())
        .netPrice(car.getNetPrice())
        .build();
  }
}
