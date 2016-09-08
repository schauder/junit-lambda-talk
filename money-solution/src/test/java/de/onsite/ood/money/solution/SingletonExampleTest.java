package de.onsite.ood.money.solution;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonExampleTest {

    @After //AfterClass //Before //BeforeClass
    public void cleanUp(){
        SingletonExample.instance.setPrefix("aaa");
    }


    @Test
    public void withStandardPrefix(){
        assertEquals("aaahallo", SingletonExample.instance.prefix("hallo"));
    }

    @Test
    public void withNonStandardPrefix(){
        SingletonExample.instance.setPrefix("bbb");
        assertEquals("bbxhallo", SingletonExample.instance.prefix("hallo"));

    }

}