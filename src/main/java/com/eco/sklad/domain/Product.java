package com.eco.sklad.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.math.BigDecimal;
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

    private BigDecimal suplyPrice = new BigDecimal("0.00");
    private BigDecimal price0 = new BigDecimal("0.00");
    private BigDecimal price = new BigDecimal("0.00");

    @Enumerated(EnumType.STRING)
    private Pcs pcs;

    @Enumerated(EnumType.STRING)
    private ProductState productState;

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

    public BigDecimal getPrice0() {
        return price0;
    }

    public void setPrice0(BigDecimal price0) {
        this.price0 = price0;
    }


    public BigDecimal getSuplyPrice() {
        return suplyPrice;
    }

    public void setSuplyPrice(BigDecimal suplyPrice) {
        this.suplyPrice = suplyPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

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
                ", state=" + productState +
//                ", productsOnStocks=" + productsOnStocks +
//                ", categoryProducts=" + categoryProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (shortName != null ? !shortName.equals(product.shortName) : product.shortName != null) return false;
        if (longName != null ? !longName.equals(product.longName) : product.longName != null) return false;
        if (partNumber != null ? !partNumber.equals(product.partNumber) : product.partNumber != null) return false;
        return pcs == product.pcs;
    }

    @Override
    public int hashCode() {
        int result = shortName != null ? shortName.hashCode() : 0;
        result = 31 * result + (longName != null ? longName.hashCode() : 0);
        return result;
    }
}
