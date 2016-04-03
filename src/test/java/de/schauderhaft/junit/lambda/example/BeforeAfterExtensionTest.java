package de.schauderhaft.junit.lambda.example;

import org.junit.gen5.api.Test;
import org.junit.gen5.api.extension.ExtendWith;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

@RunWith(JUnit5.class)
@ExtendWith({WithDatasource.class})
public class BeforeAfterExtensionTest implements NeedDatasource{

    @Test
    public void testSomething(){
        System.out.println("in test one");
    }

    @Test
    public void testSomethingElse(){
        System.out.println("in test two");
    }

    @Override
    public void set(MyDatasource ds) {
        System.out.println("set called with " + ds);
    }
}
