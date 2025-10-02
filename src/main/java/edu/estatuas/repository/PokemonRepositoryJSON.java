package edu.estatuas.repository;

import edu.estatuas.model.Pokemon;
import edu.estatuas.storage.PokemonJSONHandler;
import edu.estatuas.storage.StorageHandler;

import java.io.IOException;
import java.util.List;

public class PokemonRepositoryJSON implements PokemonRepository {

    StorageHandler storageHandler = new PokemonJSONHandler();
    List<Pokemon> pokemonList;

    @Override
    public void loadPokemons(String filepath) throws IOException {
        pokemonList = storageHandler.readFromFile(filepath);
    }

    @Override
    public List<Pokemon> getPokemonList(){

        try {
            if (pokemonList == null) {
                Exception e = new Exception("No hay lista de pokemons cargada!");
                throw e;
            } else {
                return pokemonList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
