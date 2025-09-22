package com.gandalf.enums;

public enum MaritalStatus {
    MARRIED("Evli"),
    DIVORCED("Boşanmış"),
    SINGLE("Bekar");

    private final String label;

    MaritalStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
