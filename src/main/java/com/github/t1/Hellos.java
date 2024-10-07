package com.github.t1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Random;

/// This is a new markdown javadoc.
///
/// E.g., paragraphs are just a blank line, and don't have to fall back on `<p>`.
/// And you can link classes just by putting them in square brackets: [Hellos].
/// But you can't use the [Markdown URL](http://example.com) syntax, e.g., in `@see`
/// ... for good reasons: may tools rely on that old html-_inspired_ syntax.
///
/// @see <a href=https://openjdk.org/jeps/467">JEP-467</a>
@Path("/hello")
public class Hellos {
    private static final Random RANDOM = new Random();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var ints = List.of(
                55, // byte
                1234, // short
                16_777_216, // float
                16_777_217); // none of the above

        int i = ints.get(RANDOM.nextInt(ints.size()));

        return switch (i) {
            case byte b -> "Hello, byte " + b;
            case short s -> "Hello, short " + s;
            case float f -> "Hello, float " + f;
            case int _ -> "Hello, int " + i;
        };
    }
}
