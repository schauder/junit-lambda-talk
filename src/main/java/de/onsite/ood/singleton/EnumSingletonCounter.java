package de.onsite.ood.singleton;
//tag::example[]
public enum EnumSingletonCounter {
    INSTANCE;

    private int counter = 0;
    public void increment(){
        counter++;
    }
    public int getCount(){
        return counter;
    }
}
//end::example[]