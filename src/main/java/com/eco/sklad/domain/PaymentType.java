package com.eco.sklad.domain;

public enum PaymentType {
    CASH("готівка"),
    ECO("Єврокомпоптика"),
    PPS("ПП Сиротинський")
    ;
    public String description;

    private PaymentType(String description) {
            this.description = description;
        }

    public String getPaymentType() {return description;}

    public static PaymentType fromString(String text) {
        for (PaymentType b : PaymentType.values()) {
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
        return "PaymentType{" +
                "description='" + description + '\'' +
                '}';
    }
}


