package de.onsite.ood.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * In einem realen Projekt würde dies den Datenzugriff enthalten,
 * hier nur simuliert durch eine Hashmap und einige waits.
 */
public class SlowCatRepository implements CatRepository {


    private final Map<UUID, Cat> map = new HashMap<>();

    @Override
    public UUID save(Cat cat) {
        map.put(cat.id, cat);
        sleep();
        return cat.id;
    }

    @Override
    public Cat get(UUID uuid) {
        sleep();
        return map.get(uuid);
    }

    @Override
    public void delete(UUID uuid) {
        sleep();
        map.remove(uuid);
    }

    @Override
    public List<Cat> findByName(String partOfName) {
        sleep();
        return map.values().stream()
                .filter(
                        cat -> cat.getName().toLowerCase()
                                .contains(
                                        partOfName.toLowerCase()
                                )
                )
                .collect(Collectors.toList());
    }

    private void sleep() {
        try {
            int millisToSleep = 300;
            Thread.currentThread().sleep(millisToSleep);
        } catch (InterruptedException e) {
            // we don't care
        }
    }
}
