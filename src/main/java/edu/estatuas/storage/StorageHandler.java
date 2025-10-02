package edu.estatuas.storage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface StorageHandler {
    List<Map<String, Object>> readFromFile(String filename) throws IOException;
}
