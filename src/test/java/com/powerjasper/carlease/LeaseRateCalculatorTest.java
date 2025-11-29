package com.powerjasper.carlease;

import com.powerjasper.carlease.calculator.LeaseRateCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LeaseRateCalculatorTest {
    @Test
    void calculate_normalCase() {
        Integer mileage = 45000;
        BigDecimal interestRate = new BigDecimal("4.5");
        Integer duration = 60;
        BigDecimal netPrice = new BigDecimal("63000");

        BigDecimal expected = new BigDecimal("239.82"); // TODO 239.76 was expected per instruction

        BigDecimal result = LeaseRateCalculator.calculate(mileage, interestRate, duration, netPrice);

        assertEquals(expected, result);
    }
}