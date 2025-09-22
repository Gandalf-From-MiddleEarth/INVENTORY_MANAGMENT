package com.gandalf.enums;

public enum Role {
    ADMIN("Yönetici"),
    HR("İnsan Kaynakları"),
    INVENTORY_MANAGER("Envanter Yöneticisi");

    private final String label;

    Role(String label) {
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
