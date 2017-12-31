package com.eco.sklad.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Rko {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Contragent contragent;

    @Temporal(TemporalType.DATE)
    private Date rkoDate;

    @ManyToOne
    private Cassa cassa;

    private BigDecimal usdAmount;
    private BigDecimal uahAmount;
    private BigDecimal euroAmount;
    private BigDecimal rkoAmount;
    private Double EuroUsdKurs;
    private Double UsdUahKurs;
    private String comments;

    public Rko() {
    }

    public Rko(Contragent contragent, Date rkoDate, Cassa cassa, BigDecimal usdAmount,
               BigDecimal uahAmount, BigDecimal euroAmount, BigDecimal rkoAmount,
               Double euroUsdKurs, Double usdUahKurs, String comments) {
        this.contragent = contragent;
        this.rkoDate = rkoDate;
        this.cassa = cassa;
        this.usdAmount = usdAmount;
        this.uahAmount = uahAmount;
        this.euroAmount = euroAmount;
        this.rkoAmount = rkoAmount;
        EuroUsdKurs = euroUsdKurs;
        UsdUahKurs = usdUahKurs;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
    }

    public Date getRkoDate() {
        return rkoDate;
    }

    public void setRkoDate(Date rkoDate) {
        this.rkoDate = rkoDate;
    }

    public Cassa getCassa() {
        return cassa;
    }

    public void setCassa(Cassa cassa) {
        this.cassa = cassa;
    }

    public BigDecimal getUsdAmount() {
        return usdAmount;
    }

    public void setUsdAmount(BigDecimal usdAmount) {
        this.usdAmount = usdAmount;
    }

    public BigDecimal getUahAmount() {
        return uahAmount;
    }

    public void setUahAmount(BigDecimal uahAmount) {
        this.uahAmount = uahAmount;
    }

    public BigDecimal getEuroAmount() {
        return euroAmount;
    }

    public void setEuroAmount(BigDecimal euroAmount) {
        this.euroAmount = euroAmount;
    }

    public BigDecimal getRkoAmount() {
        return rkoAmount;
    }

    public void setRkoAmount(BigDecimal rkoAmount) {
        this.rkoAmount = rkoAmount;
    }

    public Double getEuroUsdKurs() {
        return EuroUsdKurs;
    }

    public void setEuroUsdKurs(Double euroUsdKurs) {
        EuroUsdKurs = euroUsdKurs;
    }

    public Double getUsdUahKurs() {
        return UsdUahKurs;
    }

    public void setUsdUahKurs(Double usdUahKurs) {
        UsdUahKurs = usdUahKurs;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

