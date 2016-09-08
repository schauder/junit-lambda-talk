package de.schauderhaft.junit.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class $03JUnit5AsJUnit4Test {

    @Test
    public void testShouldFail(){
        Assertions.fail("This is a JUnit 5 Test which uses a Runner, so it can run as a JUnit 5 or as a JUnit 4 Test, which is great, so this fails ... whatever");
    }

}
