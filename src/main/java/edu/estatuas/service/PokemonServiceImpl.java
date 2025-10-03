package edu.estatuas.service;

import edu.estatuas.model.Move;
import edu.estatuas.repository.PokemonRepository;
import edu.estatuas.storage.StorageHandler;

import java.io.IOException;

public class PokemonServiceImpl implements PokemonService {
    PokemonRepository pokemonRepository;
    StorageHandler storageHandler;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, StorageHandler storageHandler) {
        this.pokemonRepository = pokemonRepository;
        this.storageHandler = storageHandler;
    }

    @Override
    public void loadFromFile(String filename) throws IOException {
        pokemonRepository.loadPokemons(filename);
        System.out.println("Lista de Pokemons cargada");
    }

    @Override
    public void printAllOfType(String type){
        pokemonRepository.getPokemonList().stream().filter(pokemon -> pokemon.getType().contains(type)).forEach(System.out::println);
    }

    @Override
    public void printAllOverStat(String stat, Integer value){
        pokemonRepository.getPokemonList().stream().filter(pokemon -> pokemon.getStats().get(stat)>=value).forEach(System.out::println);
    }

    @Override
    public void printAllMoveLearneable(String move){
        pokemonRepository.getPokemonList().stream().filter(pokemon -> pokemon.getMoves()
                .stream().map(Move::getName).toList().contains(move))
                .forEach(System.out::println);

    }
}
