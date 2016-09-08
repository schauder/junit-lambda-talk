package de.schauderhaft.junit.example;

import org.junit.Assert;
import org.junit.Test;

public class $01JUnit4Test {
    @Test
    public void testShouldFail(){
        Assert.assertEquals("JUnit4 test executed", 3, 1+2);
    }
}
