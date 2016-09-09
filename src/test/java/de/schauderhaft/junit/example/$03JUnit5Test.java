package de.schauderhaft.junit.example;

// tag::example[]
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

public class $03JUnit5Test {
    @Test
    public void someTest() {
        Assertions.assertEquals(9, 3*3, "JUnit5 test executed");
    }
}
// end::example[]