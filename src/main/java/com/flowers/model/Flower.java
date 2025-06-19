package com.flowers.model;

import java.util.List;

public class Flower {
    private String name;
    private List<String> careActions;

    public Flower(String name, List<String> careActions) {
        this.name = name;
        this.careActions = careActions;
    }

    public List<String> getCareActions() {
        return careActions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCareActions(List<String> careActions) {
        this.careActions = careActions;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", careActions=" + careActions +
                '}';
    }
}
