package com.eco.sklad.domain;

enum ProductState {
    BRAND_NEW("новий, запакований"),
    NEW_UNPACKED("новий, без упаковки"),
    NEW_WITHOUT_PACKAGE("новий, розпакований"),
    REFURBISHED("відновлений"),
    AS_NEW("як новий"),
    USED("бувший у використанні"),
    BROCKEN("пошкоджений");

    public String description;

    private ProductState(String description) {
        this.description = description;
    }
    public String getProductState() {return description;}
}
