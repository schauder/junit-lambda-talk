package de.schauderhaft.junit.lambda.engine;

import org.junit.gen5.engine.TestDescriptor;
import org.junit.gen5.engine.support.descriptor.AbstractTestDescriptor;

public class ClassNode extends AbstractTestDescriptor {
    private final String name;

    public ClassNode(RootTestNode root, Class<?> testSource) {
        super(root.getUniqueId() + "." + testSource);
        name = testSource.getSimpleName();
        root.addChild(this);
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
        return false;
    }

    @Override
    public boolean isContainer() {
        return true;
    }
}
