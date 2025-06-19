package com.flowers.collector;

import com.flowers.model.Gardener;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class UniqueCareActionCollector implements Collector<Gardener, Map<String, Set<String>>, Set<String>> {
    // implement supplier, accumulator, combiner, finisher, characteristics
    @Override
    public Supplier<Map<String, Set<String>>> supplier() {
        return null;
    }

    @Override
    public BiConsumer<Map<String, Set<String>>, Gardener> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<Map<String, Set<String>>> combiner() {
        return null;
    }

    @Override
    public Function<Map<String, Set<String>>, Set<String>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
    // implement supplier, accumulator, combiner, finisher, characteristics
}
