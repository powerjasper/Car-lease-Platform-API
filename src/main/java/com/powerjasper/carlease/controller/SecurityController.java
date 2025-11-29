package com.powerjasper.carlease.controller;

import com.powerjasper.carlease.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
  @Autowired private JwtUtil jwtUtils;

  @Operation(summary = "Get jwt", description = "Get a jwt for a specific user")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Jwt successfully created",
            content = @Content(schema = @Schema(implementation = String.class))),
      })
  @GetMapping("/signin/{username}")
  public String authenticateUser(
      @PathVariable("Username")
          @Parameter(
              name = "username",
              description = "Username of user",
              examples = {
                @ExampleObject(
                    name = "Broker",
                    value = "broker",
                    description = "Gives access to customer controller"),
                @ExampleObject(
                    name = "Leaser",
                    value = "leaser",
                    description = "Gives access to car controller"),
              },
              required = true)
          String username) {
    return jwtUtils.generateToken(username);
  }
}
