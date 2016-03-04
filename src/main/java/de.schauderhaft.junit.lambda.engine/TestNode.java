package de.schauderhaft.junit.lambda.engine;

import org.junit.gen5.engine.TestDescriptor;
import org.junit.gen5.engine.support.descriptor.AbstractTestDescriptor;

public class TestNode extends AbstractTestDescriptor {

    private String name;
    private final Runnable test;


    public TestNode(TestDescriptor parent, String name, Runnable test) {
        super(parent.getUniqueId() + "." + name);
        this.name = name;
        this.test = test;
        parent.addChild(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public boolean isTest() {
        return test != null;
    }

    @Override
    public boolean isContainer() {
        return !isTest();
    }

    public void executeTest() {
        test.run();
    }
}
