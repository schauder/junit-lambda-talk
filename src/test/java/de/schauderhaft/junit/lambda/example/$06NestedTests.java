package de.schauderhaft.junit.lambda.example;

import org.junit.gen5.api.Nested;
import org.junit.gen5.api.Test;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

@RunWith(JUnit5.class)
public class $06NestedTests {


    @Nested
    class NestedClass {
        @Test
        void inNested() {
        }
    }

    @RunWith(JUnit5.class)
    // Nested does not work here
    // Note that the test is in a static inner class yet not "part" of the containing test
    public static class NestedStaticClass {
        @Test
        void inStaticNested() {
        }
    }
}
