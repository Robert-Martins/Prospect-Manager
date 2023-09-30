package com.prospect.manager.infrastructure.enums;

public enum PersistType {

    CREATE("New Register"),
    UPDATE("Register Update"),
    DELETE("Register deletion");

    private final String description;

    PersistType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
