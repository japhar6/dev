package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private final App app = new App();

    @Test
    void shouldGreetName() {
        assertEquals("Hello, Jenkins!", app.greet("Jenkins"));
    }

    @Test
    void shouldUseDefaultGreetingForNull() {
        assertEquals("Hello, World!", app.greet(null));
    }

    @Test
    void shouldUseDefaultGreetingForBlankName() {
        assertEquals("Hello, World!", app.greet("   "));
    }
}