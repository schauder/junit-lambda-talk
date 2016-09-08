package de.onsite.ood.decorator;

// tag::example[]
public abstract class CatDecorator implements Cat {
    protected final Cat delegate;

    protected CatDecorator(Cat delegate) {
        this.delegate = delegate;
    }


    @Override
    public void run() {
        delegate.run();
    }
}
// end::example[]
