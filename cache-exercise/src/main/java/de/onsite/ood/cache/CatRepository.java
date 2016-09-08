package de.onsite.ood.cache;

import java.util.List;
import java.util.UUID;

public interface CatRepository {
    UUID save(Cat cat);

    Cat get(UUID uuid);

    void delete(UUID uuid);

    List<Cat> findByName(String partOfName);
}
