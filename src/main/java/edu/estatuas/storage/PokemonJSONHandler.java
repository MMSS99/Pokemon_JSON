package edu.estatuas.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.estatuas.model.Pokemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokemonJSONHandler implements StorageHandler{

    @Override
    public List<Pokemon> readFromFile(String filepath) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = mapper.readValue(Files.readString(Paths.get(filepath)), new TypeReference<Map<String, Object>>() {});

        Map<String, Object> pokedex = (Map<String, Object>) data.get("pokedex");
        List<Map<String, Object>> pokemonRawList = (List<Map<String, Object>>) pokedex.get("pokemon");

        List<Pokemon> pokemonList = pokemonRawList.stream().map(this::buildPokemon).collect(Collectors.toList());

        return pokemonList;


    }

    private Pokemon buildPokemon(Map<String, Object> rawPokemon) {

        Integer id = Integer.parseInt((String) rawPokemon.get("_id"));
        String name = (String) rawPokemon.get("name");
        List<String> type = (rawPokemon.get("type") instanceof List) ? (List<String>) rawPokemon.get("type") : new ArrayList<>(List.of((String) rawPokemon.get("type")));
        String ability = (String) rawPokemon.get("ability");
        Long exp = Long.parseLong((String) rawPokemon.get("exp"));
        Map<String, Integer> stats = (Map<String, Integer>) rawPokemon.get("stats");

        List<Map<String, String>> evolutions = (ArrayList<Map<String, String>>) ((Map<String, Object>) rawPokemon.get("evolutions")).get("evolution");


        Map<String, Double> ratio = (Map<String, Double>) rawPokemon.get("ratio");
        List<String> eggGroup = (List<String>) rawPokemon.get("eggGroup");
        String species = (String) rawPokemon.get("species");
        Double height = Double.parseDouble((String) rawPokemon.get("height"));
        Double weight = Double.parseDouble((String) rawPokemon.get("weight"));
        String description = (String) rawPokemon.get("description");
        List<Map<String, String>> moves = (List<Map<String, String>>) ((Map<String, Object>) rawPokemon.get("moves")).get("move");

        return new Pokemon(id, name, type, ability, exp, stats, evolutions, ratio, eggGroup, species, height, weight, description, moves);
    }
}
