package de.schauderhaft.junit.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({RuleExtension.class})
public class $07ExtendWithTests {


    @Nested
    class NestedClass {
        @Test
        void inNested() {
        }
    }

    // Nested does not work here
    // Note that the test is in a static inner class yet not "part" of the containing test
    public static class NestedStaticClass {
        @Test
        void inStaticNested() {
        }
    }
}
