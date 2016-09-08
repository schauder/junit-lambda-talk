package de.onsite.ood.decorator;

// tag::example[]
public class CatWithBellColar extends  CatDecorator{
    protected CatWithBellColar(Cat delegate) {
        super(delegate);
    }

    @Override
    public void run() {
        System.out.println("tinkle, tinkle");
        super.run();
        System.out.println("tinkle");
    }
}
// end::example[]
