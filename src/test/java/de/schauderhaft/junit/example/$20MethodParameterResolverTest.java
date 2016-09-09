package de.schauderhaft.junit.example;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

// tag::example[]
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({RandomParameterResolver.class})
class $20MethodParameterResolverTest {
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
// end::example[]