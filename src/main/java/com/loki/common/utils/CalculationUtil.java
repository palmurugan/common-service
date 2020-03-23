package com.loki.common.utils;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @author palmuruganc
 */
public class CalculationUtil {

    /**
     * Returns a multiplied values
     */
    public static final BinaryOperator<BigDecimal> fnDecimalMultiplication = (argument1, argument2) -> argument1.multiply(argument2);

    /**
     * Returns a calculated GST amount
     * Formula: (price * (tax / 100))
     */
    public static final BinaryOperator<BigDecimal> fnCalculateGST = (price, tax) -> price.multiply(tax.divide(BigDecimal.valueOf(100)));

    /**
     * Returns a divided value (BigDecimal)
     * Formula: value / 2
     */
    public static final Function<BigDecimal, BigDecimal> fnDecimalDivideByTwo = (argument1) -> argument1.divide(BigDecimal.valueOf(2));
}
