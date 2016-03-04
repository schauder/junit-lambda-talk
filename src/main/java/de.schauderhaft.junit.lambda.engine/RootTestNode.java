package de.schauderhaft.junit.lambda.engine;

import org.junit.gen5.engine.TestDescriptor;
import org.junit.gen5.engine.TestEngine;
import org.junit.gen5.engine.support.descriptor.AbstractTestDescriptor;

public class RootTestNode extends AbstractTestDescriptor {

    public RootTestNode(TestEngine engine) {
        super(String.format("All %s tests", engine.getId()));
    }

    @Override
    public String getName() {
        return getUniqueId();
    }

    @Override
    public String getDisplayName() {
        return getUniqueId();
    }

    @Override
    public boolean isTest() {
        return false;
    }

    @Override
    public boolean isContainer() {
        return true;
    }
}
