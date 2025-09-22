package com.gandalf.enums;

public enum Department {
    HR("İnsan Kaynakları"),
    IT("Bilgi Teknolojileri");

    private final String label;

    Department(String label) {
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
