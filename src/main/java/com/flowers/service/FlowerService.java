package com.flowers.service;

import com.flowers.collector.UniqueCareActionCollector;
import com.flowers.model.Flower;
import com.flowers.model.Gardener;
import java.util.*;
import java.util.stream.Collectors;

public class FlowerService {
    public List<String> flattenCareActions(List<Gardener> gardeners) {
        return gardeners.stream()
                .flatMap(g -> g.getAssignedFlowers().stream())
                .flatMap(f -> f.getCareActions().stream())
                .collect(Collectors.toList());
    }
    public Map<String, Long> countFlowersByType(List<Gardener> gardeners) {
        return gardeners.stream()
                .flatMap(g -> g.getAssignedFlowers().stream())
                .collect(Collectors.groupingBy(
                        Flower::getName,
                        Collectors.counting()
                ));
    }
    public Set<String> collectUniqueCareActions(List<Gardener> gardeners) {
        return gardeners.stream()
                .collect(new UniqueCareActionCollector());
    }
}
