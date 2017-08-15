package com.eco.sklad.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_person")
    private Integer idPerson;

    @Column
    private String Name;

    @Column
    private String LastName;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    private Address address;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="person", fetch = FetchType.LAZY)
    private List<Phone> phoneList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="person", fetch = FetchType.LAZY)
    private List<Email> emailList = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "person_roles",
            joinColumns = @JoinColumn(name = "id_person")
    , inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Roles> roles = new HashSet<>();

    public Person() {
    }

    public Person(String name, String lastName) {
        Name = name;
        LastName = lastName;
    }

    public Person(String name, String lastName, Address address, List<Phone> phoneList, List<Email> emailList, Set<Roles> roles) {
        Name = name;
        LastName = lastName;
        this.address = address;
        this.phoneList = phoneList;
        this.emailList = emailList;
        this.roles = roles;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
