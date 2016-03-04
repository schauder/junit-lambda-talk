package de.schauderhaft.junit.lambda.example;

import org.hamcrest.CoreMatchers;
import org.junit.gen5.api.Test;
import org.junit.gen5.api.TestInfo;
import org.junit.gen5.api.extension.ExtendWith;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.gen5.api.Assertions.assertNotNull;

@RunWith(JUnit5.class)
@ExtendWith({
        RandomParameterResolver.class
})
public class $05MethodParameterResolver {
    @Test
    void testMethodParameterResolver(
            String arg,
            TestInfo testInfo // is provided by the TestInfoResolver, which is always present
    ) {
        assertThat(testInfo.getDisplayName() , endsWith("Resolver"));

        assertThat(arg, startsWith("Jens"));
    }
}
