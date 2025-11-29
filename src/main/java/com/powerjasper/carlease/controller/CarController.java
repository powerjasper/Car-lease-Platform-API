package com.powerjasper.carlease.controller;

import com.powerjasper.carlease.model.Car;
import com.powerjasper.carlease.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    @PreAuthorize("hasRole('LEASER')")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/cars/{id}")
    @PreAuthorize("hasRole('LEASER')")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getById(id));
    }

    @PutMapping("/cars/{id}")
    @PreAuthorize("hasRole('LEASER')")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        return ResponseEntity.ok(carService.updateById(id, car));
    }

    @DeleteMapping("/cars/{id}")
    @PreAuthorize("hasRole('LEASER')")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
