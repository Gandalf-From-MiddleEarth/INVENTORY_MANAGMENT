package com.gandalf.enums;

public enum InventoryStatus {
    ASSIGNED("Atanmış"),
    IN_WAREHOUSE("Depoda"),
    IN_OFFICE("Ofiste");

    private final String label;

    InventoryStatus(String label) {
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
