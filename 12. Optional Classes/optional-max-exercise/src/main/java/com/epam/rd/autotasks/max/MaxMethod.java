package com.epam.rd.autotasks.max;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Arrays;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
            OptionalInt optMax;
            if(values!=null && values.length>0) {
                Arrays.sort(values);
                int max1 = values[values.length - 1];
                optMax = OptionalInt.of(max1);
            }
            else {
                optMax=OptionalInt.empty();
            }

        return optMax;
    }
}
