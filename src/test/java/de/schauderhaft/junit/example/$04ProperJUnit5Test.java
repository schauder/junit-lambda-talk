package de.schauderhaft.junit.example;

// tag::example[]

import org.junit.jupiter.api.*;

// class needs only package scope -> reduced noise
class $04ProperJUnit5Test {

    // new annotation
    @Test
    void someTest() { // again only package scope -> reduced noise
        // Assertions replaces Assert for simple stuff
        Assertions.assertEquals(5, quersumme(23));

        // you probably want to use AssertJ, Hamcrest or similar anyway
    }
    // end::example[]


    // tag::disabled[]
    @Test
    @Disabled
    // replaces @Ignored
    void ignored() {
    }
    // end::disabled[]

    // tag::assume[]
    @Test
    void abortTests() {
        // abort the test -> not failed, but execution stops anyway.
        Assumptions.assumeTrue(false);
    }
    // end::assume[]


    // tag::name[]
    @Test
    @DisplayName("Realy Awesome Name \uD83D\uDC4C")
    //  should be an ok symbol -------^
    void stupidName() {
    }
    // end::name[]


    // tag::exception[]
    @Test // the new @Test annotation doesn't have an 'expected'
    void testExceptions() {

        final String argument = "forty-two";
        final IllegalArgumentException exception =
                Assertions.expectThrows(IllegalArgumentException.class, () -> {
                    parseRomanNumeral(argument);
                });
        Assertions.assertTrue(exception.getMessage().contains(argument));
    }
    // end::exception[]

    int parseRomanNumeral(String numberString) {
        if (numberString.equals("XXIII")) {
            return 23;
        }
        throw new IllegalArgumentException("Can't parse " + numberString);
    }


    private int quersumme(int number) {
        return number < 10 ? number : number % 10 + quersumme(number / 10);
    }


}
