package com.eco.sklad.domain;

import org.hibernate.validator.constraints.NotBlank;

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
    @NotBlank(message = "введіть назву")
    private String shortName;
    private String longName;
//    private String serialNumber;
    private String partNumber;
    private String description;

    @Enumerated(EnumType.STRING)
    private Pcs pcs=Pcs.PCS_PCS;

//    @Enumerated(EnumType.STRING)
//    private ProductState productState;

    @ManyToOne
    @JoinColumn(name = "id_pr")
    private Producer producer=new Producer();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductsOnStock> productsOnStocks = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SupplyLines> supplyLinesList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_categories", joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name="id_category"))
    private Set<CategoryProduct> categoryProducts = new HashSet<>();

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public ProductState getProductState() {
//        return productState;
//    }
//
//    public void setProductState(ProductState productState) {
//        this.productState = productState;
//    }

    public List<ProductsOnStock> getProductsOnStocks() {
        return productsOnStocks;
    }

    public void setProductsOnStocks(List<ProductsOnStock> productsOnStocks) {
        this.productsOnStocks = productsOnStocks;
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

    public Pcs getPcs() {
        return pcs;
    }

    public void setPcs(Pcs pcs) {
        this.pcs = pcs;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", longName='" + longName + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", description='" + description + '\'' +
                ", pcs=" + pcs +
                ", producer=" + producer +
                ", productsOnStocks=" + productsOnStocks +
                ", supplyLinesList=" + supplyLinesList +
                ", categoryProducts=" + categoryProducts +
                '}';
    }
}
