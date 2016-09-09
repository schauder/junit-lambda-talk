package de.schauderhaft.junit.example;

//tag::example[]
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class $05NestedTests {

    @Nested
    class NestedClass {
        @Test
        void inNested() {}
    }

    @Test
    void inParent() {}

    // Nested does not work here
    // Note that the test is in a static inner class yet not "part" of the containing test
    static class NestedStaticClass {
        @Test
        void inStaticNested() {}
    }
}
//end::example[]