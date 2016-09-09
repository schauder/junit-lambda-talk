package de.schauderhaft.junit.example;

// tag::example[]
import org.junit.jupiter.api.extension.*;

public class WithDatasource implements
        BeforeEachCallback, AfterEachCallback, ParameterResolver {

    private MyDatasource ds;

    @Override
    public void beforeEach(TestExtensionContext testExtensionContext) {
        System.out.println("before");
        // more setup code goes here
        ds = new MyDatasource();
    }

    @Override
    public void afterEach(TestExtensionContext testExtensionContext) {
        System.out.println("after");
        ds = null;
    }

    @Override
    public boolean supports(
            ParameterContext parameterContext,
            ExtensionContext extensionContext
    ) throws ParameterResolutionException {
        return parameterContext.getParameter().getType()
                .isAssignableFrom(MyDatasource.class);
    }

    @Override
    public Object resolve(
            ParameterContext parameterContext,
            ExtensionContext extensionContext
    ) throws ParameterResolutionException {
        return ds;
    }
}
// end::example[]