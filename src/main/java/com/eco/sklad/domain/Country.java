package com.eco.sklad.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name= "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @OneToMany
//    @JoinColumn(name = "country_id", updatable=true, insertable=true)
//    private Country country;
    @Column(name="id_co")
    private int id;

    @Column(name="name", nullable = false)
    @NaturalId
    private String cName;

    public Country() {
    }

    public Country(int id, String cName) {
        this.id = id;
        this.cName = cName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + cName + '\'' +
                '}';
    }
}

