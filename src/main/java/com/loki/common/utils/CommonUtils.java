package com.loki.common.utils;

import java.util.Random;

public class CommonUtils {

    public static Long getUniqueId() {
        Random random = new Random();
        return Math.abs(random.nextLong());
    }
}
