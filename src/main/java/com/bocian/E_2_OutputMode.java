package com.bocian;

import com.bocian.service.RandomLongSumming;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class E_2_OutputMode {

    @Benchmark
    public Double someBenchmark() {
        return RandomLongSumming.add();
    }
}
