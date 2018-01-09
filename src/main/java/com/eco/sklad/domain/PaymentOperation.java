package com.eco.sklad.domain;

public enum PaymentOperation{

    FOR_GOODS("оплата за товар"),
    FOR_MATERIALS("оплата за матеріали"),
    COMMON_FEE("загальні витрати"),
    INVOICE_FEE("витрати по партії"),
    CORRECTION("корекція"),
    TEMP("тимчасова передача"),
    OTHER("інше")
    ;
    public String description;

    private PaymentOperation(String description) {
        this.description = description;
    }

    public String getPaymentOperation() {return description;}

    public static PaymentOperation fromString(String text) {
        for (PaymentOperation b : PaymentOperation.values()) {
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
        return "PaymentOperation{" +
                "description='" + description + '\'' +
                '}';
    }
}

