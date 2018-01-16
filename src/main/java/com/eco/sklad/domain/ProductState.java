package com.eco.sklad.domain;

public enum ProductState {
    BRAND_NEW("новий, запакований"),
    NEW_UNPACKED("новий, без упаковки"),
    NEW_WITH_PACKAGE("новий, розпакований"),
    REFURBISHED("відновлений"),
    AS_NEW("як новий"),
    USED("бувший у використанні"),
    BROCKEN("пошкоджений");

    public String description;

    private ProductState(String description) {
        this.description = description;
    }

    public String getProductState() {return description;}

    public static ProductState fromString(String text) {
        for (ProductState b : ProductState.values()) {
            if (b.description.equals(text.trim())) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ProductState{" +
                "description='" + description + '\'' +
                '}';
    }
}
