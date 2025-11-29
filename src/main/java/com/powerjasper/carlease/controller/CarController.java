package com.powerjasper.carlease.controller;

import com.powerjasper.carlease.model.Car;
import com.powerjasper.carlease.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class CarController {
  @Autowired private CarService carService;

  @Operation(summary = "Get all cars", description = "Get a list of all available cars")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Cars found successfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Car.class)))),
        @ApiResponse(
            responseCode = "403",
            description = "Unauthorized - User is not allowed to execute operation",
            content = @Content(schema = @Schema(hidden = true)))
      })
  @GetMapping("/cars")
  @PreAuthorize("hasRole('LEASER')")
  public ResponseEntity<List<Car>> getAllCars() {
    return ResponseEntity.ok(carService.getAllCars());
  }

  @Operation(summary = "Get a specific car", description = "Get a specific car using id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Car found successfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Car.class)))),
        @ApiResponse(
            responseCode = "404",
            description = "Not found - The car was not found",
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = "403",
            description = "Unauthorized - User is not allowed to execute operation",
            content = @Content(schema = @Schema(hidden = true)))
      })
  @GetMapping("/cars/{id}")
  @PreAuthorize("hasRole('LEASER')")
  public ResponseEntity<Car> getCar(@PathVariable Long id) {
    return ResponseEntity.ok(carService.getById(id));
  }

  @Operation(summary = "Update a specific car", description = "Update a specific car using id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Car updated successfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Car.class)))),
        @ApiResponse(
            responseCode = "404",
            description = "Not found - The car was not found",
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = "403",
            description = "Unauthorized - User is not allowed to execute operation",
            content = @Content(schema = @Schema(hidden = true)))
      })
  @PutMapping("/cars/{id}")
  @PreAuthorize("hasRole('LEASER')")
  public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
    return ResponseEntity.ok(carService.updateById(id, car));
  }

  @Operation(summary = "Delete a specific car", description = "Delete a specific car using id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Car deleted successfully",
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = "404",
            description = "Not found - The car was not found",
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = "403",
            description = "Unauthorized - User is not allowed to execute operation",
            content = @Content(schema = @Schema(hidden = true)))
      })
  @DeleteMapping("/cars/{id}")
  @PreAuthorize("hasRole('LEASER')")
  public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
    carService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
