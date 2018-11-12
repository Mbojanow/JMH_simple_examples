package com.bocian.service;

import java.util.Random;

public class SleepingRandomDoubleService {
    private static final long ONE_SECONDS_IN_MILLIS = 1000L;

    public double doJob() throws InterruptedException {
        Thread.sleep(ONE_SECONDS_IN_MILLIS);
        return new Random().nextDouble();
    }
}
