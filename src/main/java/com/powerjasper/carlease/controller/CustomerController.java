package com.powerjasper.carlease.controller;

import com.powerjasper.carlease.model.Customer;
import com.powerjasper.carlease.service.CustomerService;
import java.util.List;

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

@RestController
@SecurityRequirement(name = "bearerAuth")
public class CustomerController {
  @Autowired private CustomerService customerService;

  @Operation(summary = "Get all customer", description = "Get a list of all available customers")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Customers found successfully",
            content =
                @Content(array = @ArraySchema(schema = @Schema(implementation = Customer.class)))),
        @ApiResponse(
            responseCode = "403",
            description = "Unauthorized - User is not allowed to execute operation",
            content = @Content(schema = @Schema(hidden = true)))
      })
  @GetMapping("/customers")
  @PreAuthorize("hasRole('BROKER')")
  public ResponseEntity<List<Customer>> getAllCustomers() {
    return ResponseEntity.ok(customerService.getAllCustomers());
  }

  @Operation(summary = "Get a specific customer", description = "Get a specific customer using id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Customer found successfully",
            content =
                @Content(array = @ArraySchema(schema = @Schema(implementation = Customer.class)))),
        @ApiResponse(
            responseCode = "404",
            description = "Not found - The customer was not found",
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = "403",
            description = "Unauthorized - User is not allowed to execute operation",
            content = @Content(schema = @Schema(hidden = true)))
      })
  @GetMapping("/customers/{id}")
  @PreAuthorize("hasRole('BROKER')")
  public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.getById(id));
  }

  @Operation(
      summary = "Update a specific customer",
      description = "Update a specific customer using id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Customer updated successfully",
            content =
                @Content(array = @ArraySchema(schema = @Schema(implementation = Customer.class)))),
        @ApiResponse(
            responseCode = "404",
            description = "Not found - The customer was not found",
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = "403",
            description = "Unauthorized - User is not allowed to execute operation",
            content = @Content(schema = @Schema(hidden = true)))
      })
  @PutMapping("/customers/{id}")
  @PreAuthorize("hasRole('BROKER')")
  public ResponseEntity<Customer> updateCustomer(
      @PathVariable Long id, @RequestBody Customer customer) {
    return ResponseEntity.ok(customerService.updateById(id, customer));
  }

  @Operation(
      summary = "Delete a specific customer",
      description = "Delete a specific customer using id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Customer deleted successfully",
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = "404",
            description = "Not found - The customer was not found",
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = "403",
            description = "Unauthorized - User is not allowed to execute operation",
            content = @Content(schema = @Schema(hidden = true)))
      })
  @DeleteMapping("/customers/{id}")
  @PreAuthorize("hasRole('BROKER')")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    customerService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
