package de.onsite.ood.cache;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CachedRepositoryTest {
    private final CatRepository internalRepository = spy(new SlowCatRepository());
    private final CatRepository repository = new CachedRepository("cache name", internalRepository);

    private final Cat inCache = new Cat(UUID.randomUUID());
    private final Cat notInCache = new Cat(UUID.randomUUID());

    {
        inCache.setName("InCache");
        repository.save(inCache);

        notInCache.setName("NotInCache");
        internalRepository.save(notInCache);
    }

    @Test
    public void accessByIdServesFromCacheIfPossible() {

        Cat loadedCat = repository.get(inCache.id);

        assertEquals(inCache.id, loadedCat.id);
        verify(internalRepository, never()).get(loadedCat.id);
    }

    @Test
    public void accessByIdServesFromMainRepositoryOnCacheMiss() {

        Cat loadedCat = repository.get(notInCache.id);

        assertEquals(notInCache.id, loadedCat.id);
        verify(internalRepository).get(loadedCat.id);
    }

    @Test
    public void loadingUpdatesTheCache() {

        Cat loadedCat = repository.get(notInCache.id);
        repository.get(notInCache.id);

        assertEquals(notInCache.id, loadedCat.id);
        verify(internalRepository).get(loadedCat.id);
    }
    @Test
    public void deleteRemovesFromCache() {

        repository.delete(inCache.id);

        assertNull(repository.get(inCache.id));
    }
}
