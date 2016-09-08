package de.schauderhaft.junit.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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
