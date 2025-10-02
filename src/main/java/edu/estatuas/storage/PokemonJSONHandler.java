package edu.estatuas.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.estatuas.model.Pokemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class PokemonJSONHandler implements StorageHandler{

    @Override
    public List<Map<String, Object>> readFromFile(String filepath) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = mapper.readValue(Files.readString(Paths.get(filepath)), new TypeReference<Map<String, Object>>() {});

        Map<String, Object> pokedex = (Map<String, Object>) data.get("pokedex");
        List<Map<String, Object>> pokemonRawList = (List<Map<String, Object>>) pokedex.get("pokemon");

        return pokemonRawList;


    }

    private Pokemon buildPokemon(Map<String, Object> rawPokemon) {

    }
}
