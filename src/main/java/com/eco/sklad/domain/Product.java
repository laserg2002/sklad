package com.eco.sklad.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String shortName;
    private String longName;
//    private String serialNumber;
    private String partNumber;
    private String odVymiru;

    @ManyToOne
    @JoinColumn(name = "id_pr", updatable=true, insertable=true)
    private Producer producer;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SupplyLines> supplyLinesList = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_categories", joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name="id_category"))
    private Set<CategoryProduct> categoryProducts = new HashSet<>();

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SupplyLines> getSupplyLinesList() {
        return supplyLinesList;
    }

    public void setSupplyLinesList(List<SupplyLines> supplyLinesList) {
        this.supplyLinesList = supplyLinesList;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getOdVymiru() {
        return odVymiru;
    }

    public void setOdVymiru(String odVymiru) {
        this.odVymiru = odVymiru;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Set<CategoryProduct> getCategoryProducts() {
        return categoryProducts;
    }

    public void setCategoryProducts(Set<CategoryProduct> categoryProducts) {
        this.categoryProducts = categoryProducts;
    }
}
