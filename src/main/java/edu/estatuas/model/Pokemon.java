package edu.estatuas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokemon {
    private Integer id;
    private String name;
    private List<String> type;
    private String ability;
    private Long exp;
    private Map<String, Integer> stats;
    private List<Evolution> evolutions;
    private Map<String, Double> ratio;
    private List<String> eggGroup;
    private String species;
    private Double height;
    private Double weight;
    private String description;
    private List<Move> moves;

    public Pokemon(
            Integer id, String name, List<String> type, String ability, Long exp, Map<String, Integer> stats,
            List<Evolution> evolutions, Map<String, Double> ratio, List<String> eggGroup, String species,
            Double height, Double weight, String description, List<Move> moves
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ability = ability;
        this.exp = exp;
        this.stats = stats;
        this.evolutions = evolutions;
        this.ratio = ratio;
        this.eggGroup = eggGroup;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.moves = moves;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getType() {
        return type;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return getId().toString() + ": " + getName();
    }
}
