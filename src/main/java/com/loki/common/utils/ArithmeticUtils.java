package com.loki.common.utils;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;
import java.util.function.LongBinaryOperator;

public class ArithmeticUtils {

    public static final LongBinaryOperator sumLong = Long::sum;
    public static final BinaryOperator<BigDecimal> sumDecimal = BigDecimal::add;

    private ArithmeticUtils() {
    }

    public static BigDecimal add(BigDecimal argument1, BigDecimal argument2) {
        return argument1.add(argument2);
    }

    public static Long add(Long argument1, Long argument2) {
        return argument1 + argument2;
    }
}
