package com.eco.sklad.domain;

import groovy.transform.Field;
import org.hibernate.annotations.NaturalId;
//import org.springframework.data.annotation.Id;

import javax.naming.Name;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pr")
    private Integer idPr;

    @NotNull
    @Column(name="full_name", nullable = false, insertable = false, updatable = false, unique = true)
    private String fullName;

    @Size(min = 1, max = 1, message = "введіть 1 символ")
    @Column(name="pr_category")
    private String categoryProducer;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", updatable=true, insertable=true)
    private Country country;

    public Producer() {
    }

    public Producer(String fullName, String categoryProducer, Country country) {
        this.fullName = fullName;
        this.categoryProducer = categoryProducer;
        this.country = country;
    }

    public Integer getIdPr() {
        return idPr;
    }

    public void setIdPr(Integer idPr) {
        this.idPr = idPr;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCategoryProducer() {
        return categoryProducer;
    }

    public void setCategoryProducer(String categoryProducer) {
        this.categoryProducer = categoryProducer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "idPr=" + idPr +
                ", fullName='" + fullName + '\'' +
                ", categoryProducer='" + categoryProducer + '\'' +
                ", country=" + country +
                '}';
    }
}
