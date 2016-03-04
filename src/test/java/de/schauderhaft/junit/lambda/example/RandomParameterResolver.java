package de.schauderhaft.junit.lambda.example;

import org.junit.gen5.api.extension.ExtensionContext;
import org.junit.gen5.api.extension.MethodInvocationContext;
import org.junit.gen5.api.extension.MethodParameterResolver;
import org.junit.gen5.api.extension.ParameterResolutionException;

import java.lang.reflect.Parameter;
import java.util.UUID;

public class RandomParameterResolver implements MethodParameterResolver{
    @Override
    public boolean supports(Parameter parameter, MethodInvocationContext methodInvocationContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameter.getType() == String.class;
    }

    @Override
    public Object resolve(Parameter parameter, MethodInvocationContext methodInvocationContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return "Jens" + UUID.randomUUID();
    }
}
