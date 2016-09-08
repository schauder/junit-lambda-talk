package de.schauderhaft.junit.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class $02JUnit5Test {
    @Test
    public void testShouldFail() {
        Assertions.fail("JUnit5 test executed, which is great, so this fails ... whatever");
    }
}
