package com.eco.sklad.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Supplies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateOfSupply;

    @ManyToOne
    private Contragent supplier;

    private BigDecimal total;

    @OneToMany(mappedBy = "supply", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplyLines> supplyList = new ArrayList<>();



    public Supplies() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SupplyLines> getSupplyList() {
        return supplyList;
    }

    public void setSupplyList(List<SupplyLines> supplyList) {
        this.supplyList = supplyList;
    }

    public Date getDateOfSupply() {
        return dateOfSupply;
    }

    public void setDateOfSupply(Date dateOfSupply) {
        this.dateOfSupply = dateOfSupply;
    }

    public Contragent getSupplier() {
        return supplier;
    }

    public void setSupplier(Contragent supplier) {
        this.supplier = supplier;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
