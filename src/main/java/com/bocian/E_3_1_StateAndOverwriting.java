package com.bocian;

import com.bocian.service.RandomLongSumming;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class E_3_1_StateAndOverwriting {

    private List<Double> doubles = Arrays.asList(1.0, 1.1, 1.2, 1.3, 1.4);

    @Benchmark
    public Double thrbenchmark() {
        return RandomLongSumming.addFromList(doubles) * 1.0;
    }

    @Benchmark
    public Double anotherBenchmark() {
        return RandomLongSumming.addFromList(doubles) * 2.0;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public Double yetAnotherBenchmark() {
        return RandomLongSumming.addFromList(doubles) * 3.0;
    }
}
