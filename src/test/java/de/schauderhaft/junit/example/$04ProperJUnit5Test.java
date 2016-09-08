package de.schauderhaft.junit.example;


import org.junit.jupiter.api.*;

public
// class needs only package scope -> reduced noise
class $04ProperJUnit5Test {

    // new annotation
    @Test
    void shouldFail() { // again only package scope -> reduced noise
        // Assertions replaces Assert for simple stuff
        Assertions.assertEquals(5, quersumme(23), "JUnit5 test executed, which is great, so this fails ... whatever");

        // you probably want to use AssertJ, Hamcrest or similar anyway
    }
    @Test
    @Disabled
        // replaces @Ignored
    void ignored() {
    }

    @Test
    void abortTests() {
        Assumptions.assumeTrue(false); // abort the test -> not failed, but execution stops anyway.
    }


    @Test
    @DisplayName("Realy Awesome Name \uD83D\uDC4C")
        // <-- should be an ok symbol
    void stupidName() {
    }


    @Test
    void testExceptions() { // the new @Test annotation doesn't have an 'expected'

        final String argument = "forty-two";
        final IllegalArgumentException exception = Assertions.expectThrows(IllegalArgumentException.class, () -> {
            parseRomanNumeral(argument);
        });
        Assertions.assertTrue(exception.getMessage().contains(argument));
    }

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
