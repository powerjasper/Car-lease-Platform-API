package com.powerjasper.carlease.service;

import com.powerjasper.carlease.calculator.LeaseRateCalculator;
import com.powerjasper.carlease.model.LeaseRateRequest;
import com.powerjasper.carlease.model.LeaseRateResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LeaseRateService {

    public LeaseRateResponse calculateLeaseRate(LeaseRateRequest leaseRateRequest) {
        final BigDecimal leaseRate = LeaseRateCalculator.calculate(leaseRateRequest.getMileage(), leaseRateRequest.getInterestRate(), leaseRateRequest.getDuration(), leaseRateRequest.getNetPrice());
        return new LeaseRateResponse(leaseRate);
    }
}
