package com.eco.sklad.domain;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Contragent {
    @Id
    private int id;

    @NaturalId
    @NotEmpty
    private String balansName;

    private String companyName;
    private Boolean allowMinus=false;
    private int balansCredit=0;

    @OneToOne
            (optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "supplier", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Supplies> suppliesList = new ArrayList<>();

    @OneToMany(mappedBy = "customer", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orderList = new ArrayList<>();

    public Contragent() {
    }

    public Contragent(int id, String balansName, String companyName, User user) {
        this.id = id;
        this.balansName = balansName;
        this.companyName = companyName;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Supplies> getSuppliesList() {
        return suppliesList;
    }

    public void setSuppliesList(List<Supplies> suppliesList) {
        this.suppliesList = suppliesList;
    }

    public Boolean getAllowMinus() {
        return allowMinus;
    }

    public void setAllowMinus(Boolean allowMinus) {
        this.allowMinus = allowMinus;
    }

    public int getBalansCredit() {
        return balansCredit;
    }

    public void setBalansCredit(int balansCredit) {
        this.balansCredit = balansCredit;
    }

    public String getBalansName() {
        return balansName;
    }

    public void setBalansName(String balansName) {
        this.balansName = balansName;
    }

    public Optional getUser() {
        return Optional.ofNullable(this.user);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
