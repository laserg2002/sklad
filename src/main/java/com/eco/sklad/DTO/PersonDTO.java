package com.eco.sklad.DTO;

import javax.validation.constraints.NotNull;

public class PersonDTO {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String city;
    private String postIndex;
    private String street;
    private String comment;
    @NotNull
    private String phone1;
    private Boolean viber1;
    private String phone2;
    private Boolean viber2;
    @NotNull
    private String email1;
    private String email2;

    public PersonDTO() {
    }
    public PersonDTO(Integer id, String name, String lastName, String city, String postIndex,
                     String street, String comment, String phone1, String phone2, String email1, String email2) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.postIndex = postIndex;
        this.street = street;
        this.comment = comment;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email1 = email1;
        this.email2 = email2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Boolean getViber1() {
        return viber1;
    }

    public void setViber1(Boolean viber1) {
        this.viber1 = viber1;
    }

    public Boolean getViber2() {
        return viber2;
    }

    public void setViber2(Boolean viber2) {
        this.viber2 = viber2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
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

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
}