package de.onsite.ood.singleton;

//tag::example[]
public final class LazySingletonCounter {
    private static LazySingletonCounter instance = null;

    private LazySingletonCounter(){
        // intialize instance
    }

    public static synchronized LazySingletonCounter getInstance() {
        if (instance == null){
            instance = new LazySingletonCounter();
        }
        return instance;
    }

    private int counter = 0;
    public void increment() { counter++; }
    public int getCount() { return counter; }
}
//end::example[]