package de.schauderhaft.junit.example;

// tag::example[]
import org.junit.jupiter.api.extension.*;

import java.util.UUID;

public class RandomParameterResolver implements ParameterResolver {

    @Override
    public boolean supports(
            ParameterContext parameterContext,
            ExtensionContext extensionContext
    ) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == String.class;
    }

    @Override
    public Object resolve(
            ParameterContext parameterContext,
            ExtensionContext extensionContext
    ) throws ParameterResolutionException {
        return "Jens" + UUID.randomUUID();
    }
}
// end::example[]