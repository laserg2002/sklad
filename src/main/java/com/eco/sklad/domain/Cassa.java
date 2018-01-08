package com.eco.sklad.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cassa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;

//    @OneToMany(mappedBy = "cassa", orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Pko> pkoList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "cassa", orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Rko> rkoList = new ArrayList<>();

    private String cassaName;
    private BigDecimal balance;

    public Cassa() {
    }
}
