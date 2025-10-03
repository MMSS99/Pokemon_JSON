package edu.estatuas.model;

import java.util.Optional;

public class Move {
    private String name;
    private Optional<Integer> level = Optional.empty();
    private String type;
    private Optional<String> machine =  Optional.empty();

    public Move(String name, String type){

    }

    public Move(String name, Integer level, String type) {
        this.name = name;
        this.level = Optional.of(level);
        this.type = type;
    }

    public Move(String name, Integer level, String type, String machine) {
        this.name = name;
        this.level = Optional.of(level);
        this.type = type;
        this.machine = Optional.of(machine);
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level.isPresent() ? level.get() : 0;
    }

    public String getType() {
        return type;
    }

    public Optional<String> getMachine() {
        return machine.isPresent() ? machine : Optional.empty();
    }
}


