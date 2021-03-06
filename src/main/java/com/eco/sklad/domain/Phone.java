package com.eco.sklad.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Entity
@Table(name = "phone")
public class Phone {

    @ManyToOne
    private Person person;

    @NotNull
    @Id
    @Column
    private String phone;

    private boolean viber;

    public Phone() {
    }

    public Phone(String phone) {
        this.phone = phone;
    }

    public Phone(Person person, String phone, boolean viber) {
        this.person = person;
        this.phone = phone;
        this.viber = viber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isViber() {
        return viber;
    }

    public void setViber(boolean viber) {
        this.viber = viber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                ", phone='" + phone + '\'' +
                ", viber=" + viber +
                '}';
    }
}
