package com.example;

public class App {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, World!";
        }

        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.greet("Jenkins"));
    }
}