package com.flowers;

import com.flowers.model.Flower;
import com.flowers.model.Gardener;
import com.flowers.service.FlowerService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class FlowerSystemDemo {
    public static void main(String[] args) {
        Flower rose1 = new Flower("Rose", Arrays.asList("water", "prune"));
        Flower tulip1 = new Flower("Tulip", Arrays.asList("water", "fertilize"));
        Flower lily1 = new Flower("Lily", Arrays.asList("water"));

        Flower rose2 = new Flower("Rose", Arrays.asList("water", "fertilize"));
        Flower tulip2 = new Flower("Tulip", Arrays.asList("prune"));

        Gardener alice = new Gardener("Alice", Arrays.asList(rose1, tulip1));
        Gardener bob = new Gardener("Bob", Arrays.asList(lily1, rose2));
        Gardener clara = new Gardener("Clara", List.of(tulip2));

        List<Gardener> gardeners = Arrays.asList(alice, bob, clara);

        FlowerService service = new FlowerService();

        List<String> allActions = service.flattenCareActions(gardeners);
        System.out.println("All Care Actions (Flattened):");
        System.out.println(allActions);
        System.out.println();

        Map<String, Long> flowerCount = service.countFlowersByType(gardeners);
        System.out.println("Flower Counts by Type:");
        flowerCount.forEach((flower, count) -> System.out.println(flower + ": " + count));
        System.out.println();

        Set<String> uniqueActions = service.collectUniqueCareActions(gardeners);
        System.out.println("Unique Care Actions:");
        System.out.println(uniqueActions);
    }
}
