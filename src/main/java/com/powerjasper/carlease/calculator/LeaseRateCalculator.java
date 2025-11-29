package com.powerjasper.carlease.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseRateCalculator {

  public static BigDecimal calculate(
      Integer mileage, BigDecimal interestRate, Integer duration, BigDecimal netPrice) {
    final BigDecimal mileageToPriceRatio = getMileageToPriceRatio(mileage, duration, netPrice);
    final BigDecimal interestPerMonth = getInterestPerMonth(interestRate, netPrice);

    return mileageToPriceRatio.add(interestPerMonth);
  }

  private static BigDecimal getMileageToPriceRatio(
      Integer mileage, Integer duration, BigDecimal netPrice) {
    final int mileagePerMonth = mileage / 12;
    final int mileageOverContractDuration = mileagePerMonth * duration;
    return new BigDecimal(mileageOverContractDuration).divide(netPrice, 2, RoundingMode.HALF_UP);
  }

  private static BigDecimal getInterestPerMonth(BigDecimal interestRate, BigDecimal netPrice) {
    final BigDecimal interestRateDecimal =
        interestRate.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
    final BigDecimal interestOverNetPrice = interestRateDecimal.multiply(netPrice);
    return interestOverNetPrice.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
  }
}
