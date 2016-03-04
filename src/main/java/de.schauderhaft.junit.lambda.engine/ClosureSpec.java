package de.schauderhaft.junit.lambda.engine;

public interface ClosureSpec {
    default void test(String name, Runnable test){
        ClosureEngine.register(name, test);
    }
}
