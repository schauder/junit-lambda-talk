package de.onsite.ood.cache;


import java.util.HashMap;
import java.util.Map;

public enum CacheManager {
    instance;

    private final Map<String, Cache> caches = new HashMap<>();

    public Cache getCache(String name) {
        Cache cache = caches.get(name);
        if (cache == null) {
            cache = new Cache();
            caches.put(name, cache);
        }
        return cache;
    }

}
