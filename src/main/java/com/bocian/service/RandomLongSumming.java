package com.bocian.service;

import java.util.List;
import java.util.Random;

public class RandomLongSumming {

    public static double add() {
        final long numbersToAdd = 1000000L;

        long sum = 0;
        for (long i = 0; i < numbersToAdd; i++) {
            sum += new Random().nextDouble();
        }

        return sum;
    }

    public static double addFromList(final List<Double> doubles) {
        return doubles.stream().mapToDouble(d -> d).sum() + new Random().nextDouble();
    }

    public static double add(final int numValues) {
        long sum = 0;
        for (long i = 0; i < numValues; i++) {
            sum += new Random().nextDouble();
        }

        return sum;
    }
}
