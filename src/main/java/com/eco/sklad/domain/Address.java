package com.eco.sklad.domain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name="id_owner")
    private Integer idAddress;

    @OneToOne
//    @MapsId
    @JoinColumn(name = "id_owner")
    private Person person;

    @Column(name="region")
    private String region;

    @Column(name="city_name")
    private String cityName;

    @Column(name="street_address")
    private String street;

    @Column
    private String comment;

    public Address() {
    }

    public Address(Integer idAddress, String cityName) {
        this.idAddress = idAddress;
        this.cityName = cityName;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getRegion() {
        return region;
    }

    public void setIndex(String region) {
        this.region = region;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", region='" + region + '\'' +
                ", cityName='" + cityName + '\'' +
                ", street='" + street + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
