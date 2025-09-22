package com.gandalf.enums;

public enum Position {
    HUMAN_RESOURCE("İnsan Kaynakları"),
    DEVELOPER("Yazılımcı");

    private final String label;

    Position(String label) {
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
