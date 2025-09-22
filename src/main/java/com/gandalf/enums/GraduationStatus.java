package com.gandalf.enums;

public enum GraduationStatus {
    ASSOCIATE("Ön Lisans"),
    BACHELOR("Lisans"),
    MASTER("Yüksek Lisans"),
    PHD("Doktora");

    private final String label;

    GraduationStatus(String label) {
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
