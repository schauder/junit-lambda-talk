package de.schauderhaft.junit.example;

import org.junit.jupiter.api.*;

class $07BeforeAfterTest {
// tag::example[]
    @BeforeAll
    static void beforeAll(){ System.out.println("before all"); }

    @BeforeEach
    void before(){ System.out.println("before"); }

    @Test
    void testOne() { System.out.println("one"); }

    @Test
    void testTwo() { System.out.println("two"); }

    @AfterAll
    static void afterAll(){ System.out.println("after all"); }

    @AfterEach
    void after(){ System.out.println("after"); }
//end::example[]
}
