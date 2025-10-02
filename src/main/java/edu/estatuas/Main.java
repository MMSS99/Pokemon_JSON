package edu.estatuas;

import edu.estatuas.model.Pokemon;
import edu.estatuas.storage.PokemonJSONHandler;
import edu.estatuas.storage.StorageHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StorageHandler storage = new PokemonJSONHandler();

        try {
            List<Pokemon> lista = storage.readFromFile("./data/pokemon.json");
            lista.forEach(System.out::println);
        } catch (Exception e) { e.printStackTrace(); }


    }
}