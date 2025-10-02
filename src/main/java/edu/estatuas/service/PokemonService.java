package edu.estatuas.service;

import java.io.IOException;

public interface PokemonService {
    public void loadFromFile(String filename) throws IOException;

    void printAllOfType(String type);

    void printAllOverStat(String stat, Integer value);

    void printAllMoveLearneable(String move);
}
