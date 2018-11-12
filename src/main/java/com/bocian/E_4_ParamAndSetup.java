package com.bocian;

import com.bocian.service.RandomLongSumming;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 3, time = 3)
@Measurement(iterations = 5, time = 3)
@Fork(1)
public class E_4_ParamAndSetup {

    @State(Scope.Benchmark)
    public static class ValuesState {
        @Param({"1", "10", "1000000"})
        Integer numOfValues;
    }

    @Benchmark
    public double addingOneMoreTimeBenchmark(ValuesState valuesState) {
        //System.out.println("Value = " + valuesState.numOfValues);
        return RandomLongSumming.add(valuesState.numOfValues);
    }
}
