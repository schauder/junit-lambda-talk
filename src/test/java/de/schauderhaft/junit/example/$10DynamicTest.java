package de.schauderhaft.junit.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith({RandomParameterResolver.class})
public class $10DynamicTest {
    @Test
    void testMethodParameterResolver(
            String arg,
            // provided by the TestInfoResolver,
            // which is always present
            TestInfo testInfo
    ) {
        assertThat(testInfo.getDisplayName(), containsString("Resolver"));

        assertThat(arg, startsWith("Jens"));
    }
}
