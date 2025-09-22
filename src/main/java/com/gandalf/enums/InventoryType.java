package com.gandalf.enums;

public enum InventoryType {
    COMPUTER("Bilgisayar"),
    MONITOR("Monitör"),
    MOUSE("Fare"),
    KEYBOARD("Klavye");

    private final String label;

    InventoryType(String label) {
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

