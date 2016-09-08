package de.schauderhaft.junit.example;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class WithDatasource implements BeforeEachCallback, AfterEachCallback {

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
