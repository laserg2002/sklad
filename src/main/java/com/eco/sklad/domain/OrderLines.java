package com.eco.sklad.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SupplyLines> supplyLinesList = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;
    private BigDecimal salePrice = new BigDecimal(0);

    @Enumerated(EnumType.STRING)
    private SaleType salesType;

    public OrderLines() {
    }

    public OrderLines(Product product, int quantity, BigDecimal salePrice) {
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
    }

    public OrderLines(Product product, int quantity, BigDecimal salePrice, SaleType salesType) {
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.salesType = salesType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getTotal(){
        return this.salePrice.multiply(new BigDecimal(this.quantity));
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SaleType getSalesType() {
        return salesType;
    }

    public void setSalesType(SaleType salesType) {
        this.salesType = salesType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "OrderLines{" +
                "id=" + id +
                ", order=" + order.getId() +
                ", product=" + product.getId() +
                ", quantity=" + quantity +
                ", salePrice=" + salePrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLines that = (OrderLines) o;

        if (!product.equals(that.product)) return false;
        if (!salePrice.equals(that.salePrice)) return false;
        return salesType.equals(that.salesType);
    }

    @Override
    public int hashCode() {
//    shortName != null ? shortName.hashCode() : 0;
        int result = this.product != null ? this.product.hashCode() : 99;
        result = 31 * result + quantity;
        result = 31 * result + (salePrice != null ? salePrice.hashCode() : 99);
        result = 31 * result + (salesType != null ? salesType.hashCode() : 99);
        return result;
    }
}
