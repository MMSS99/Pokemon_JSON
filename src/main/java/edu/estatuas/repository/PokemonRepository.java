package edu.estatuas.repository;

import edu.estatuas.model.Pokemon;

import java.io.IOException;
import java.util.List;

public interface PokemonRepository {

    void loadPokemons(String filepath) throws IOException;
    List<Pokemon> getPokemonList();
}
