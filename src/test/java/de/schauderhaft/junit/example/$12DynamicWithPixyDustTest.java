package de.schauderhaft.junit.example;

import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

// tag::example[]
class $12DynamicWithPixyDustTest extends LambdaBasedTests {{
        List<Integer> ints = asList(Integer.MAX_VALUE, Integer.MIN_VALUE, -1, 0, 1, 2, 10);

        for (Integer i : ints) {
            for (Integer j : ints) {
                test(
                        format("adding integers is commutative (%d, %d)", i, j),
                        () -> {
                            assertEquals(i + j, j + i);
                        });
            }
        }
    }}
// end::example[]