package com.rohanbari.andromath;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ProblemGenerator {
    private static final int UPPER = 100;

    private static int var1;
    private static int var2;
    private static String op;

    public static int getVar1() {
        return var1;
    }

    public static int getVar2() {
        return var2;
    }

    public static String getOp() {
        return op;
    }

    /**
     * Generates the necessary random values between a range and
     * a random operator in which the calculation will based on in
     * order to perform the required task.
     */
    public static void generate() {
        long seed = System.nanoTime();
        Random random = new Random(seed);
        List<String> operator = new ArrayList<>();

        var1 = random.nextInt(UPPER) + 1;
        var2 = random.nextInt(UPPER) + 1;

        operator.add("+");
        operator.add("-");
        operator.add("*");

        op = String.format(Locale.ENGLISH,
                "%s",
                operator.get(random.nextInt(operator.size())));
    }
}
