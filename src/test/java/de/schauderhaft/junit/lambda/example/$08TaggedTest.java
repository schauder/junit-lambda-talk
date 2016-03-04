package de.schauderhaft.junit.lambda.example;


import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Assumptions;
import org.junit.gen5.api.Disabled;
import org.junit.gen5.api.DisplayName;
import org.junit.gen5.api.Tag;
import org.junit.gen5.api.Tags;
import org.junit.gen5.api.Test;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

@RunWith(JUnit5.class)
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
