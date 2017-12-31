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

    private BigDecimal usdAmount = new BigDecimal(0);
    private BigDecimal uahAmount = new BigDecimal(0);
    private BigDecimal euroAmount = new BigDecimal(0);
    private BigDecimal pkoAmount = new BigDecimal(0);
    private Double EuroUsdKurs;
    private Double UsdUahKurs;
    private String comments;

    public Pko() {
    }

    public Pko(Contragent contragent, Date pkoDate, Cassa cassa, BigDecimal usdAmount,
               BigDecimal uahAmount, BigDecimal euroAmount, BigDecimal pkoAmount,
               Double euroUsdKurs, Double usdUahKurs, String comments) {
        this.contragent = contragent;
        this.pkoDate = pkoDate;
        this.cassa = cassa;
        this.usdAmount = usdAmount;
        this.uahAmount = uahAmount;
        this.euroAmount = euroAmount;
        this.pkoAmount = pkoAmount;
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

    public Date getPkoDate() {
        return pkoDate;
    }

    public void setPkoDate(Date pkoDate) {
        this.pkoDate = pkoDate;
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

    public BigDecimal getPkoAmount() {
        return pkoAmount;
    }

    public void setPkoAmount(BigDecimal pkoAmount) {
        this.pkoAmount = pkoAmount;
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

