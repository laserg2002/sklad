package com.eco.sklad.DTO;

import java.math.BigDecimal;

public class InvoiceLineDTO {
    private int id;
    private int productId;
    private String productName;
    private int quantity=1;
    private int invoiceId;
    private BigDecimal price = new BigDecimal("0");
    private BigDecimal discount = new BigDecimal("0");
    private BigDecimal extraFee = new BigDecimal("0");
    private BigDecimal finalPrice = new BigDecimal("0");
    private BigDecimal itemTotal = new BigDecimal("0");
    private String salesType = "1";

    public InvoiceLineDTO() {
    }

    public InvoiceLineDTO(int id) {
        this.id = id;
    }

    public InvoiceLineDTO(int id, int productId, int quantity, String productName, BigDecimal price) {
        this.productId = productId;
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.itemTotal = price.multiply(new BigDecimal(quantity));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getExtraFee() {
        return extraFee;
    }

    public void setExtraFee(BigDecimal extraFee) {
        this.extraFee = extraFee;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceLineDTO that = (InvoiceLineDTO) o;

        if (productId != that.productId) return false;
        if (quantity != that.quantity) return false;
        if (!price.equals(that.price)) return false;
        return salesType.equals(that.salesType);
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + quantity;
        result = 31 * result + price.hashCode();
        result = 31 * result + salesType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "InvoiceLineDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", invoice=" + invoiceId +
                ", itemTotal=" + itemTotal +
                ", salesType='" + salesType + '\'' +
                '}';
    }
}
