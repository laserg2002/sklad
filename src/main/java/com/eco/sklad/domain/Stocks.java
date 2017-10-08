package com.eco.sklad.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stocks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "stocks", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductsOnStock> productsOnStocks = new ArrayList<>();

    private String stockName;

    public Stocks() {
    }
}
