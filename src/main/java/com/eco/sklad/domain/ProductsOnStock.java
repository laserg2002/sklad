package com.eco.sklad.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
public class ProductsOnStock {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_product", updatable=true, insertable=true)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_stock", updatable=true, insertable=true)
    private Stocks stocks;

    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

    private int quantity=0;
    private BigDecimal price1 = new BigDecimal("0.00");
    private BigDecimal price2 = new BigDecimal("0.00");
    private BigDecimal price3 = new BigDecimal("0.00");
    private String grade;

    public ProductsOnStock() {
    }
}
