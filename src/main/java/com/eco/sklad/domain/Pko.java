package com.eco.sklad.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Pko {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Contragent contragent;

    @Temporal(TemporalType.DATE)
    private Date pkoDate;

    @ManyToOne
    private Cassa cassa;

    private BigDecimal usdAmount;
    private BigDecimal uahAmount;
    private BigDecimal total;
    private Double kurs;
    private String comments;

    public Pko() {
    }
}

