package de.schauderhaft.junit.lambda.example;

import org.junit.gen5.api.extension.AfterEachExtensionPoint;
import org.junit.gen5.api.extension.BeforeEachExtensionPoint;
import org.junit.gen5.api.extension.TestExtensionContext;

public class WithDatasource implements BeforeEachExtensionPoint, AfterEachExtensionPoint {

    @Override
    public void beforeEach(TestExtensionContext testExtensionContext) {
        System.out.println("before");
        ((NeedDatasource)testExtensionContext.getTestInstance()).set(new MyDatasource());
    }

    @Override
    public void afterEach(TestExtensionContext testExtensionContext) {
        System.out.println("after");
        ((NeedDatasource)testExtensionContext.getTestInstance()).set(null);
    }
}
