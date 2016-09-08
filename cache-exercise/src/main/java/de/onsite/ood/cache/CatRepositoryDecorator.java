package de.onsite.ood.cache;

import java.util.List;
import java.util.UUID;

public abstract class CatRepositoryDecorator implements CatRepository{
    private final CatRepository delegate;

    public CatRepositoryDecorator(CatRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public UUID save(Cat cat) {
        return delegate.save(cat);
    }

    @Override
    public Cat get(UUID uuid) {
        return delegate.get(uuid);
    }

    @Override
    public void delete(UUID uuid) {
        delegate.delete(uuid);
    }

    @Override
    public List<Cat> findByName(String partOfName) {
        return delegate.findByName(partOfName);
    }
}
