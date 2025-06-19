package com.flowers.model;

import java.util.List;

public class Gardener {
    private String name;
    private List<Flower> assignedFlowers;

    public Gardener(String name, List<Flower> assignedFlowers) {
        this.name = name;
        this.assignedFlowers = assignedFlowers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flower> getAssignedFlowers() {
        return assignedFlowers;
    }

    public void setAssignedFlowers(List<Flower> assignedFlowers) {
        this.assignedFlowers = assignedFlowers;
    }
}
