package edu.estatuas.model;

import java.util.Optional;

public class Evolution {

    private Integer ID;
    private String name;
    private Optional<Integer> level =  Optional.empty();

    public Evolution(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Evolution(Integer ID, String name, Integer level) {
        this.ID = ID;
        this.name = name;
        this.level = Optional.of(level);
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Optional<Integer> getLevel() {
        return level;
    }
}

