package com.flowers.collector;

import com.flowers.model.Flower;
import com.flowers.model.Gardener;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class UniqueCareActionCollector implements Collector<Gardener, Map<String, Set<String>>, Set<String>> {

    @Override
    public Supplier<Map<String, Set<String>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Set<String>>, Gardener> accumulator() {
        return (map, gardener) -> {
            Set<String> actions = map.computeIfAbsent(gardener.getName(), k -> new HashSet<>());
            for (Flower flower : gardener.getAssignedFlowers()) {
                actions.addAll(flower.getCareActions());
            }
        };
    }

    @Override
    public BinaryOperator<Map<String, Set<String>>> combiner() {
        return (map1, map2) -> {
            map2.forEach((name, actions) ->
                    map1.merge(name, actions, (set1, set2) -> {
                        set1.addAll(set2);
                        return set1;
                    })
            );
            return map1;
        };
    }

    @Override
    public Function<Map<String, Set<String>>, Set<String>> finisher() {
        return map -> {
            Set<String> allActions = new HashSet<>();
            map.values().forEach(allActions::addAll);
            return allActions;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }
}