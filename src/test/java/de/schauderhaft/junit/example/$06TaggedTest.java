package de.schauderhaft.junit.example;

// tag::example[]
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("super")
@Tags({@Tag("awesome"), @Tag("cool")})
class $06TaggedTest {

    @Test
    void impressiveTest() {
    }

    @Test
    @Tag("nice")
    void evenBetterTest() {
    }

    @FastTest
    void metaAnnotatedTest() {
    }
}
//end::example[]