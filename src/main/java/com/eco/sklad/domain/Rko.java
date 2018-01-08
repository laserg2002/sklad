package com.eco.sklad.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Rko {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    private CassaOperation cassaOperation;

    @ManyToOne
    private Contragent contragent;

    @Temporal(TemporalType.DATE)
    private Date rkoDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    private String managerName;

    private BigDecimal usdAmount=new BigDecimal("0");
    private BigDecimal uahAmount=new BigDecimal("0");
    private BigDecimal euroAmount=new BigDecimal("0");
    private BigDecimal rkoAmount=new BigDecimal("0");
    private Double EuroUsdKurs=1.18d;
    private Double UsdUahKurs=28.3d;
    private String comments;

    public Rko() {
    }

    public Rko(Contragent contragent, Date rkoDate, BigDecimal usdAmount,
               BigDecimal uahAmount, BigDecimal euroAmount, BigDecimal rkoAmount,
               Double euroUsdKurs, Double usdUahKurs, String comments) {
        this.contragent = contragent;
        this.rkoDate = rkoDate;
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public CassaOperation getCassaOperation() {
        return cassaOperation;
    }

    public void setCassaOperation(CassaOperation cassaOperation) {
        this.cassaOperation = cassaOperation;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}

