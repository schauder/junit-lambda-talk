package de.schauderhaft.junit.lambda.example;

import de.schauderhaft.junit.lambda.engine.ClosureSpec;

import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


public class ExampleClosureTest implements ClosureSpec {
    {
        test("a simple test, testing if pi is equal to 3", () -> {
            System.out.println("in closure a");
            assertThat(Math.PI, equalTo(3));
        });

        test("e is >= 2", () -> {
            System.out.println("in closure b");
            assertThat(Math.E, greaterThan(2.0));
        });
    }

}
