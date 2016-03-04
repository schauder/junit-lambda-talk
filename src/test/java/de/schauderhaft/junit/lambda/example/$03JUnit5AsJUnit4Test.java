package de.schauderhaft.junit.lambda.example;


import org.junit.Assert;
import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

/**
 * This one works in IDE and Gradle.
 *
 * Tight integration with IDE fails in various ways
 */

@RunWith(JUnit5.class)
public class $03JUnit5AsJUnit4Test {

    @Test
    public void testShouldFail(){
        Assertions.fail("This is a JUnit 5 Test which uses a Runner, so it can run as a JUnit 5 or as a JUnit 4 Test, which is great, so this fails ... whatever");
    }

}
