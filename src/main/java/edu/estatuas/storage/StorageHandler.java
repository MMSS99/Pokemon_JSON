package edu.estatuas.storage;

import edu.estatuas.model.Pokemon;

import java.io.IOException;
import java.util.List;

public interface StorageHandler {
    List<Pokemon> readFromFile(String filename) throws IOException;
}
