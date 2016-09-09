package de.schauderhaft.junit.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


// tag::example[]
class $10DynamicWithCollectionTest {
    private List<Integer> ints = asList(
            Integer.MAX_VALUE, Integer.MIN_VALUE, -1, 0, 1, 2, 10
    );

    @TestFactory
    List<DynamicTest> additionIsCommutative() {
        List<DynamicTest> tests = new ArrayList<>();
        for (Integer i : ints) {
            for (Integer j : ints) {
                tests.add(dynamicTest(
                        i + " + " + j,
                        () -> {
                            assertEquals(i + j, j + i);
                        }));
            }
        }
        return tests;
    }
}
// end::example[]
