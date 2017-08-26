package com.eco.sklad.DTO;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class PersonDTO {
    private Integer id;
    @NotBlank(message = "введіть ім'я")
    private String name;
    private String lastName;
    private String region;
    @NotBlank(message = "введіть місто")
    private String city;
    private String street;
    private String comment;
    @Pattern(regexp = "^\\+\\d{2}\\(\\d{3}\\)\\d{7}$", message = "номер телефона має відповідати формату +38(067)6767676" )
    private String phone1;
    private Boolean viber1;
    private String phone2;
    private Boolean viber2;
    @NotBlank(message = "введіть e-mail")
    @Email(message = "некоректний e-mail №1")
    private String email1;
    @Email(message = "некоректний e-mail №2")
    private String email2;

    public PersonDTO() {
    }
    public PersonDTO(Integer id, String name, String lastName, String city, String region,
                     String street, String comment, String phone1, String phone2, String email1, String email2) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.region = region;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDTO personDTO = (PersonDTO) o;

        if (id != null ? !id.equals(personDTO.id) : personDTO.id != null) return false;
        if (!name.equals(personDTO.name)) return false;
        if (!lastName.equals(personDTO.lastName)) return false;
        if (!city.equals(personDTO.city)) return false;
        if (street != null ? !street.equals(personDTO.street) : personDTO.street != null) return false;
        if (comment != null ? !comment.equals(personDTO.comment) : personDTO.comment != null) return false;
        if (!phone1.equals(personDTO.phone1)) return false;
        if (viber1 != null ? !viber1.equals(personDTO.viber1) : personDTO.viber1 != null) return false;
        if (phone2 != null ? !phone2.equals(personDTO.phone2) : personDTO.phone2 != null) return false;
        if (viber2 != null ? !viber2.equals(personDTO.viber2) : personDTO.viber2 != null) return false;
        if (!email1.equals(personDTO.email1)) return false;
        return email2 != null ? email2.equals(personDTO.email2) : personDTO.email2 == null;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", comment='" + comment + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", viber1=" + viber1 +
                ", phone2='" + phone2 + '\'' +
                ", viber2=" + viber2 +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                '}';

    }
}