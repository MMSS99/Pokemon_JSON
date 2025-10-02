package edu.estatuas;

import edu.estatuas.model.Pokemon;
import edu.estatuas.repository.PokemonRepositoryJSON;
import edu.estatuas.service.PokemonService;
import edu.estatuas.service.PokemonServiceImpl;
import edu.estatuas.storage.PokemonJSONHandler;
import edu.estatuas.storage.StorageHandler;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PokemonService pokemonService = new PokemonServiceImpl(new PokemonRepositoryJSON(), new PokemonJSONHandler());
        try {pokemonService.loadFromFile("./data/pokemon.json");} catch (IOException e) {e.printStackTrace();}

        System.out.println("\nPrintando pokemons del tipo Water:");
        pokemonService.printAllOfType("Water");

        System.out.println("\nPrintando pokemons con HP mayor a 60:");
        pokemonService.printAllOverStat("HP", 60);

        System.out.println("\nPrintando pokemons que pueden aprender Fuerza:");
        pokemonService.printAllMoveLearneable("Strength");



    }
}