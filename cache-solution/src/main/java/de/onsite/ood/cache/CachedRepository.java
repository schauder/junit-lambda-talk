package de.onsite.ood.cache;

import java.util.List;
import java.util.UUID;

class CachedRepository implements CatRepository {

    private final CatRepository internalRepository;
    private final Cache cache;

    CachedRepository(String cacheName, CatRepository internalRepository) {
        this.internalRepository = internalRepository;
        cache = CacheManager.instance.getCache(cacheName);
    }

    @Override
    public UUID save(Cat cat) {
        cache.put(cat.id.toString(), cat);
        return internalRepository.save(cat);
    }

    @Override
    public Cat get(UUID uuid) {
        Cat fromCache = (Cat) cache.get(uuid.toString());
        if (fromCache != null)
            return fromCache;
        else {
            Cat cat = internalRepository.get(uuid);
            cache.put(uuid.toString(), cat);
            return cat;
        }
    }

    @Override
    public void delete(UUID uuid) {
        cache.put(uuid.toString(), null);
        internalRepository.delete(uuid);
    }

    @Override
    public List<Cat> findByName(String partOfName) {
        return internalRepository.findByName(partOfName);
    }
}
