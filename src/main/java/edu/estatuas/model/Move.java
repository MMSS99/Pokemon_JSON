package edu.estatuas.model;

import java.util.Optional;

public class Move {
    private String name;
    private Integer level;
    private String type;
    private Optional<String> machine =  Optional.empty();

    public Move(String name, Integer level, String type) {
        this.name = name;
        this.level = level;
        this.type = type;
    }

    public Move(String name, Integer level, String type, String machine) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.machine = Optional.of(machine);
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public Optional<String> getMachine() {
        return machine;
    }
}


