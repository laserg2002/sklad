package com.eco.sklad.domain;

public enum SaleType {

    SALE("продаж"),
    PAYMENT_DELAY("з відстрочкою платежа"),
    REALISATION("під реалізацію"),
    TEST("на тест"),
    RETURN("повернення"),
    OTHER("інше");

    public String description;

    private SaleType(String description) {
        this.description = description;
    }

    public String getSaleType() {
        return description;
    }

    public static com.eco.sklad.domain.SaleType fromString(String text) {
        for (com.eco.sklad.domain.SaleType b : com.eco.sklad.domain.SaleType.values()) {
            if (b.description.equals(text.trim())) {
                return b;
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "SaleType{" +
                "description='" + description + '\'' +
                '}';
    }
}


