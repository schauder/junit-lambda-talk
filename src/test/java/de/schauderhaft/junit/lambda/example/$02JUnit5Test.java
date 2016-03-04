package de.schauderhaft.junit.lambda.example;


import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;

public class $02JUnit5Test {
    @Test
    public void testShouldFail() {
        Assertions.fail("JUnit5 test executed, which is great, so this fails ... whatever");
    }
}
