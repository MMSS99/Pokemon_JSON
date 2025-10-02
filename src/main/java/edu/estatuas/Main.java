package edu.estatuas;

import edu.estatuas.storage.PokemonJSONHandler;
import edu.estatuas.storage.StorageHandler;

public class Main {
    public static void main(String[] args) {

        StorageHandler storage = new PokemonJSONHandler();

        try {
            storage.readFromFile("./data/pokemon.json");
        } catch (Exception e) { e.printStackTrace(); }


    }
}