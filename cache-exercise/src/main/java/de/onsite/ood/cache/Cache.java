package de.onsite.ood.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * nicht wirklich ein Cache sondern nur eine gekapselte Map, aber für die Übung reicht es.
 */
public class Cache {
    private Map<String, Serializable> values = new HashMap<>();

    public void put(String key, Serializable value) {
        values.put(key, value);
    }

    public Object get(String key) {
        return values.get(key);
    }
}
