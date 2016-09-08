package de.onsite.ood.singleton;

//tag::example[]
public final class EagerSingletonCounter {
    public static final EagerSingletonCounter instance =
            new EagerSingletonCounter();

    private EagerSingletonCounter(){
        // intialize instance
    }

    private int counter = 0;
    public void increment() {
        counter++;
    }
    public int getCount() {
        return counter;
    }
}
//end::example[]