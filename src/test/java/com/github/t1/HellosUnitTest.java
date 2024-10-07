package com.github.t1;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.BDDAssertions.then;

class HellosUnitTest {
    Hellos hellos = new Hellos();

    @RepeatedTest(10)
    void testHellos() {
        var hello = hellos.hello();

        System.out.println(hello);
        then(hello).startsWith("Hello, ");
    }
}
