package de.schauderhaft.junit.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// tag::example[]
@ExtendWith({WithDatasource.class})
public class $21BeforeAfterExtensionTest {

    @Test
    public void testSomething(MyDatasource ds){
        System.out.println("in test one with DS" + ds);
    }

    @Test
    public void testSomethingElse(MyDatasource ds){
        System.out.println("in test two with DS" + ds);
    }

}
// end::example[]