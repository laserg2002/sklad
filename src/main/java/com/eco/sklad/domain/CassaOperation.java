package com.eco.sklad.domain;

public enum CassaOperation {

    FOR_GOODS("оплата за товар"),
    FOR_SERVICE("оплата за послуги"),
    CORRECTION("корекція"),
    TEMP("тимчасова передача"),
    OTHER("інше")
    ;
    public String description;

    private CassaOperation(String description) {
        this.description = description;
    }

    public String getCassaOperation() {return description;}

    public static CassaOperation fromString(String text) {
        for (CassaOperation b : CassaOperation.values()) {
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
        return "CassaOperation{" +
                "description='" + description + '\'' +
                '}';
    }
}
