package de.schauderhaft.junit.example;

// tag::example[]
public class MyDatasource {
    private static int counter = 0;

    {counter++;}

    @Override
    public String toString() {
        return "MyDatasource #" + counter;
    }
}
// end::example[]
