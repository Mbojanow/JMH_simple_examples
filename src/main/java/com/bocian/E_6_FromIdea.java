package com.bocian;

import com.bocian.service.SleepingRandomDoubleService;
import org.junit.Assert;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class E_6_FromIdea {


    private final SleepingRandomDoubleService sleepingRandomDoubleService = new SleepingRandomDoubleService();

    @Benchmark
    public void sleepingServiceJobBenchmark(final Blackhole blackhole) throws InterruptedException {
        final Double retValue = sleepingRandomDoubleService.doJob();
        blackhole.consume(retValue);
    }

    @Test
    public void runAllBenchmarksInThisClass() throws RunnerException {
        final Options benchmarkOptions = new OptionsBuilder()
                .shouldFailOnError(true)
                .forks(1)
                .threads(1)
                .measurementIterations(3)
                .measurementTime(TimeValue.microseconds(1000))
                .warmupForks(2)
                .warmupIterations(3)
                .warmupTime(TimeValue.microseconds(2000))
                .include("E_6_FromIdea")
                .timeout(TimeValue.seconds(1000))
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();

        final Collection<RunResult> benchmarkResults = new Runner(benchmarkOptions).run();

        benchmarkResults.forEach(runResult -> {
            final Result primary = runResult.getPrimaryResult();
            Assert.assertTrue("method execution time too long. You suck!",
                    primary.getScore() <= 1);
        });
    }
}

