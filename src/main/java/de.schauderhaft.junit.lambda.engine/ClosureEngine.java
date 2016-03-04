package de.schauderhaft.junit.lambda.engine;

import org.junit.gen5.commons.util.ReflectionUtils;
import org.junit.gen5.engine.EngineDiscoveryRequest;
import org.junit.gen5.engine.EngineExecutionListener;
import org.junit.gen5.engine.ExecutionRequest;
import org.junit.gen5.engine.TestDescriptor;
import org.junit.gen5.engine.TestEngine;
import org.junit.gen5.engine.TestExecutionResult;
import org.junit.gen5.engine.discovery.ClassSelector;
import org.junit.gen5.engine.discovery.ClasspathSelector;

import java.util.List;
import java.util.function.Predicate;

public class ClosureEngine implements TestEngine {

    private RootTestNode root;
    private static ClassNode currentNode;

    public ClosureEngine() {
        System.out.println("closure engine created");
    }

    @Override
    public TestDescriptor discover(EngineDiscoveryRequest discoveryRequest) {
        root = new RootTestNode(this);


        handleClassSelectors(discoveryRequest);
        handleClasspathSelectors(discoveryRequest);

        return root;
    }

    private void handleClassSelectors(EngineDiscoveryRequest discoveryRequest) {
        final List<ClassSelector> selectors = discoveryRequest.getSelectorsByType(ClassSelector.class);
        for (ClassSelector selector : selectors) {

            Class<?> testSource = selector.getTestClass();
            try {
                if (ClosureSpec.class.isAssignableFrom(testSource)) {

                    currentNode = new ClassNode(root, testSource);

                    testSource.newInstance();
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                currentNode = null;
            }
        }
    }

    private void handleClasspathSelectors(EngineDiscoveryRequest discoveryRequest) {
        final List<ClasspathSelector> selectors = discoveryRequest.getSelectorsByType(ClasspathSelector.class);
        for (ClasspathSelector selector : selectors) {

            final List<Class<?>> testSources = ReflectionUtils.findAllClassesInClasspathRoot(selector.getClasspathRoot(), isTestCandidate());
            for (Class<?> testSource : testSources) {
                try {
                    testSource.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Predicate<Class<?>> isTestCandidate() {
        return (Class<?> c) -> ClosureSpec.class.isAssignableFrom(c) && !c.isInterface();
    }


    @Override
    public void execute(ExecutionRequest request) {
        final EngineExecutionListener listener = request.getEngineExecutionListener();
        request.getRootTestDescriptor().accept(new TestDescriptor.Visitor() {
            @Override
            public void visit(TestDescriptor descriptor, Runnable remove) {
                TestExecutionResult result = null;
                listener.executionStarted(descriptor);

                if (descriptor instanceof TestNode) {
                    TestNode node = ((TestNode) descriptor);
                    if (node.isTest()) {
                        try {
                            node.executeTest();
                        } catch (Exception ex) {
                            result = TestExecutionResult.failed(ex);
                        }

                    }
                }
                if (result == null)
                    listener.executionFinished(descriptor, TestExecutionResult.successful());
                else
                    listener.executionFinished(descriptor, result);
            }
        });
    }

    public static void register(String name, Runnable test) {
        if (currentNode != null) {
            System.out.println("registering: " + name);
            new TestNode(currentNode, name, test);
        } else {
            System.out.println(" not in registration phase");
        }
    }
}
