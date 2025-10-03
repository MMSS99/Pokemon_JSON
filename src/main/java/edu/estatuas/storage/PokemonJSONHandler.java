package edu.estatuas.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.estatuas.model.Evolution;
import edu.estatuas.model.Move;
import edu.estatuas.model.Pokemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
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
        Map<String, Integer> stats = ((Map<String, String>) rawPokemon.get("stats")).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, valor -> Integer.parseInt(valor.getValue().toString())));



        // ratio puede no existir???
        Map<String, Double> ratio;
        try {
            ratio = ((Map<String, String>) rawPokemon.get("ratio")).entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, valor -> Double.parseDouble(valor.getValue().toString())));
        } catch (NullPointerException e) {
            ratio = new HashMap<>();
            ratio.put("Unisex", 100d);
        }

        List<String> eggGroup = (rawPokemon.get("egg-group") instanceof List) ? (List<String>) rawPokemon.get("egg-group") : new ArrayList<>(List.of((String) rawPokemon.get("egg-group")));
        String species = (String) rawPokemon.get("species");
        Double height = Double.parseDouble((String) rawPokemon.get("height"));
        Double weight = Double.parseDouble((String) rawPokemon.get("weight"));
        String description = (String) rawPokemon.get("description");

        // objeto evoluciones
        List<Map<String, String>> evolutionList = (ArrayList<Map<String, String>>) ((Map<String, Object>) rawPokemon.get("evolutions")).get("evolution");
        List<Evolution> evolutions = new ArrayList<>();
        for (Map<String, String> rawEvolution : evolutionList) {
            Evolution evolutionInstance;
            if (rawEvolution.size() == 2){
                evolutionInstance = new Evolution(
                        Integer.parseInt(rawEvolution.get("_id")),
                        rawEvolution.get("name")
                );
            } else {
                evolutionInstance = new Evolution(
                        Integer.parseInt(rawEvolution.get("_id")),
                        rawEvolution.get("name"),
                        Integer.parseInt(rawEvolution.get("level"))
                );
            }
            evolutions.add(evolutionInstance);
        }

        //objeto movimientos
        List<Map<String, String>> moveList = (List<Map<String, String>>) ((Map<String, Object>) rawPokemon.get("moves")).get("move");
        List<Move> moves = new ArrayList<>();
        for (Map<String, String> rawMove : moveList) {
            Move moveInstance;
            if (rawMove.size() == 3){
                moveInstance = new Move(
                        rawMove.get("name"),
                        Integer.parseInt(rawMove.get("lvl")),
                        rawMove.get("type")
                );
            } else {
                moveInstance = new Move(
                        rawMove.get("name"),
                        Integer.parseInt(rawMove.get("lvl")),
                        rawMove.get("type"),
                        rawMove.get("machine")
                );
            }
            moves.add(moveInstance);
        }

        return new Pokemon(id, name, type, ability, exp, stats, evolutions, ratio, eggGroup, species, height, weight, description, moves);
    }
}
