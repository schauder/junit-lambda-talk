package de.onsite.ood.cache;

import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class SlowCatRepositoryTest {
    @Test
    public void anEmptyRepositoryContainsNoCats() {
        assertEquals(0,new SlowCatRepository().findByName("").size());
    }

    @Test
    public void catsInTheRepositoryCanBeRetrievedFromTheRepository() {
        SlowCatRepository repository = new SlowCatRepository();

        Cat cat = new Cat(UUID.randomUUID());
        cat.setName("My Cat");

        repository.save(cat);

        assertEquals(cat.id, repository.get(cat.id).id);
        List<Cat> byName = repository.findByName("y c");
        assertEquals(1, byName.size());
        assertEquals(cat.id, byName.get(0).id);
    }

}