package de.schauderhaft.junit.lambda.example;

import org.junit.Assert;
import org.junit.Test;

public class $01JUnit4Test {
    @Test
    public void testShouldFail(){
        Assert.fail("JUnit4 test executed, which is great, so this fails ... whatever");
    }

}
