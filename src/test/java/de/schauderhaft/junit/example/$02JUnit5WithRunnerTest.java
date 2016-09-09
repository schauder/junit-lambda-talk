package de.schauderhaft.junit.example;

// tag::example[]
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class $02JUnit5WithRunnerTest {
    @Test
    public void someTest() {
        Assertions.assertEquals(9, 3*3, "Msg last");
    }
}
// end::example[]