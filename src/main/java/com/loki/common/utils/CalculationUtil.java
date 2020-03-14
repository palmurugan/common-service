package com.loki.common.utils;

import java.math.BigDecimal;
import java.util.function.BiFunction;

/**
 * @author palmuruganc
 */
public class CalculationUtil {

    public static final BiFunction<BigDecimal, BigDecimal, BigDecimal> fnDecimalMultiplication = (itemCost, itemQuantity) -> itemCost.multiply(itemQuantity);
}
