package com.eco.sklad.domain;

public enum Pcs {
    PCS_PCS("шт"),
    PCS_M("м"),
    PCS_KG("кг");

    public String description;

    private Pcs(String description) {
        this.description = description;
    }

    public String getPcs() {return description;}

    public static Pcs fromString(String text) {
        for (Pcs b : Pcs.values()) {
            if (b.description.equals(text.trim())) {
                return b;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Pcs{" +
                "description='" + description + '\'' +
                '}';
    }
}

