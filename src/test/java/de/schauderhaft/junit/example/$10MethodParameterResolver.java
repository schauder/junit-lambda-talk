package de.schauderhaft.junit.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith({
        RandomParameterResolver.class
})
public class $10MethodParameterResolver {
    @Test
    void testMethodParameterResolver(
            String arg,
            TestInfo testInfo // is provided by the TestInfoResolver, which is always present
    ) {
        assertThat(testInfo.getDisplayName() , containsString("Resolver"));

        assertThat(arg, startsWith("Jens"));
    }
}
