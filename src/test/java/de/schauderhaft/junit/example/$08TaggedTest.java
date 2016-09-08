package de.schauderhaft.junit.example;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public
@Tag("super")
@Tags({@Tag("awesome"), @Tag("cool")})
class $08TaggedTest {

    @Test
    void impressiveTest() {
        //
    }

    @Test
    @Tag("nice")
    void evenBetterTest() {
        //
    }


    @FastTest
    void metaAnnotatedTest() {
        //
    }
}
