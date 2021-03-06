package com.eco.sklad.domain;

import com.eco.sklad.DTO.UserDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NaturalId
    @NotEmpty
    private String balansName;

    private String companyName;
    private String managerName;

    private Double totalBalance;

    private Boolean allowMinus=false;
    private int balansCredit=0;

    @OneToOne
            (optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Supplies> suppliesList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orderList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "contragent", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Pko> pkoList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "contragent", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Rko> rkoList = new ArrayList<>();

    public Contragent() {
    }

    public Contragent(String managerName) {
        this.managerName = managerName;
    }

    public Contragent(UserDTO userDTO) {
        this.balansName = userDTO.getBalansName();
        this.companyName = userDTO.getCompanyName();
        this.managerName = userDTO.getManagerName();
        this.balansCredit = userDTO.getBalansCredit();
        this.user = userDTO.getUser();
    }

    public Contragent(int id) {
        this.id = id;
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

//    public Optional getUser() {
//        return Optional.ofNullable(this.user);
//    }


    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Pko> getPkoList() {
        return pkoList;
    }

    public void setPkoList(List<Pko> pkoList) {
        this.pkoList = pkoList;
    }

    public List<Rko> getRkoList() {
        return rkoList;
    }

    public void setRkoList(List<Rko> rkoList) {
        this.rkoList = rkoList;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public User getUser() {
        return this.user;
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

    @Override
    public String toString() {
        return "Contragent{" +
                "id=" + id +
                ", balansName='" + balansName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", balansCredit=" + balansCredit +
                ", user=" + user +
                '}';
    }
}
