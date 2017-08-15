package com.eco.sklad.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
    @Table (name = "email")
    public class Email {

    @Id
    private int id;

    @ManyToOne
    @JoinTable(name = "person")
//    @JoinColumn(name="id")
    private Person person;

    @NaturalId
    @NotNull
    @Column(name="e_mail")
    private String email;

    public Email() {
    }

    public Email(Person person, String email) {
        this.person = person;
        this.email = email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                ", e-mail='" + email + '\'' +
                '}';
    }
}
