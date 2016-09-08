package de.onsite.ood.cache;

import java.util.List;
import java.util.UUID;

public class CachedCatRepository extends CatRepositoryDecorator {
    public CachedCatRepository(CatRepository delegate) {
        super(delegate);
    }

    private Cache getCache() {
        return CacheManager.instance.getCache("Katzen");
    }

    @Override
    public UUID save(Cat cat) {
        getCache().put(cat.id.toString(), cat);
        return super.save(cat);
    }

    @Override
    public Cat get(UUID uuid) {
        Object cat = getCache().get(uuid.toString());
        if (cat != null)
            return (Cat) cat;
        else
            return super.get(uuid);
    }

    @Override
    public void delete(UUID uuid) {
        getCache().put(uuid.toString(), null);
        super.delete(uuid);
    }
}
