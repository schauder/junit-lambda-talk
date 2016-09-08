package de.schauderhaft.junit.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class $02JUnit5Test {
    @Test
    public void testShouldFail() {
        Assertions.assertEquals(9, 3*3, "JUnit5 test executed");
    }
}
