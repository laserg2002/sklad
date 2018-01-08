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

    @Override
    public String toString() {
        return "Pcs{" +
                "description='" + description + '\'' +
                '}';
    }
}

