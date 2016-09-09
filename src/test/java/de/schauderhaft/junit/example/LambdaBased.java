package de.schauderhaft.junit.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Executable;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
// tag::example[]
public abstract class LambdaBased {
    private List<DynamicTest> allTests = new ArrayList<>();

    @TestFactory
    List<DynamicTest> allTests(){
        return allTests;
    }

    /** registers a test
     * @param name name of the test
     * @param executable the actual test
     * */
    protected void test(String name, Executable executable){
        allTests.add(DynamicTest.dynamicTest(name, executable));
    }
}
// end::example[]
