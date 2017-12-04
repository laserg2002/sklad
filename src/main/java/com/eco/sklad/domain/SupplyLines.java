package com.eco.sklad.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class SupplyLines {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Supplies supply;

    @ManyToOne
    private Product product;

    private int quantity;
    private BigDecimal price;

    public SupplyLines() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplies getSupply() {
        return supply;
    }

    public void setSupply(Supplies supply) {
        this.supply = supply;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
}
