package com.eco.sklad.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
    private Cassa cassa;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Stocks> stockList = new ArrayList<>();

    private String workTitle;

    public Employee() {
    }
}
