package de.schauderhaft.junit.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

public class $03JUnit5WithRunnerTest {
    @Test
    public void testShouldFail() {
        Assertions.assertEquals(9, 3*3, "JUnit5 test executed");
    }
}
