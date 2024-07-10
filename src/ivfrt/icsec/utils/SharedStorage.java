package ivfrt.icsec.utils;

// SharedStorage.java

import java.util.concurrent.ConcurrentHashMap;

public class SharedStorage {
    private static ConcurrentHashMap<String, Integer> storage = new ConcurrentHashMap<String, Integer>();
    
    public static void put(String key, int value) {
        storage.put(key, value);
    }
    
    public static Integer get(String key) {
        return storage.get(key); // Returns null if key does not exist
    }
}
