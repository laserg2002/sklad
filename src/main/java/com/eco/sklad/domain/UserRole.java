package com.eco.sklad.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class UserRole {

@Id
private int id;

@ManyToMany(mappedBy = "authorities")
private Set<User> users = new HashSet<>();

@Enumerated(EnumType.STRING)
private ListRole listRole;

    public UserRole() {
    }

    public UserRole(Set<User> users, ListRole listRole) {
        this.users = users;
        this.listRole = listRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public ListRole getListRole() {
        return listRole;
    }

    public void setListRole(ListRole listRole) {
        this.listRole = listRole;
    }
}
