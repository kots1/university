package com.test.university.model;

public enum Degree {
    ASSISTANT("assistant"),
    ASSOCIATE_PROFESSOR("associate professor"),
    PROFESSOR("professor");
    private final String name;

    Degree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
