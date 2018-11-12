package com.bocian;

import com.bocian.service.SomeRandomService;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Measurement(iterations = 2, time = 2)
@Warmup(iterations = 2, time = 2)
@Threads(4)
public class E_5_MultithreadingGroups {

    private static final String GROUP_A = "A";
    private static final String GROUP_B = "B";

    @State(Scope.Benchmark)
    public static class SomeRandomServiceState {

        SomeRandomService someRandomService;

        @Setup(Level.Trial)
        public void init() {
            someRandomService = new SomeRandomService();
            someRandomService.init();
        }

        @TearDown
        public void tearDown() {
            someRandomService.destroy();
        }
    }

    @Benchmark
    @Group(GROUP_A)
    public void doJobAAndB(final SomeRandomServiceState someRandomServiceState, final Blackhole blackhole) {
        final Double aJobValue = someRandomServiceState.someRandomService.doJobA();
        final Double bJobValue = someRandomServiceState.someRandomService.doJobB();
        blackhole.consume(aJobValue);
        blackhole.consume(bJobValue);
    }

    @Benchmark
    @Group(GROUP_B)
    @GroupThreads(1)
    public void doJobA(final SomeRandomServiceState someRandomServiceState, final Blackhole blackhole) {
        final Double aJobRes = someRandomServiceState.someRandomService.doJobA();
        blackhole.consume(aJobRes);
    }

    @Benchmark
    @Group(GROUP_B)
    @GroupThreads(3)
    public void doJobB(final SomeRandomServiceState someRandomServiceState, final Blackhole blackhole) {
        final Double bJobRes = someRandomServiceState.someRandomService.doJobB();
        blackhole.consume(bJobRes);
    }
}
