package de.onsite.ood.decorator;

// tag::example[]
public class SwimmingCat extends  CatDecorator{
    protected SwimmingCat(Cat delegate) {
        super(delegate);
    }

    public void swim() {
        System.out.println("Look I can swim. I'm a tiger!");
    }
}
// end::example[]
