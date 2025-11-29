package com.powerjasper.carlease.controller;

import com.powerjasper.carlease.model.LeaseRateRequest;
import com.powerjasper.carlease.model.LeaseRateResponse;
import com.powerjasper.carlease.service.LeaseRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class LeaseRateController {
    @Autowired private LeaseRateService leaseRateService;

    @Operation(summary = "Calculate lease rate", description = "Calculate leaserate based on given properties")
    @ApiResponse()
    @PostMapping("/leaseRate")
    @PreAuthorize("hasRole('LEASER')")
    public ResponseEntity<LeaseRateResponse> calculateLeaseRate(@RequestBody LeaseRateRequest leaseRateRequest){
        return ResponseEntity.ok(leaseRateService.calculateLeaseRate(leaseRateRequest));
    }
}
