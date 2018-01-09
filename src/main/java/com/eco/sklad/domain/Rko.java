package com.eco.sklad.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Rko {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int rkoid=0;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    private PaymentOperation paymentOperation;

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
    @Generated( value = GenerationTime.ALWAYS )
    private BigDecimal rkoAmount;
    private Float EuroUsdKurs=1.18f;
    private Float UsdUahKurs=28.3f;
    private String comments;

    public Rko() {
    }

    public Rko(Contragent contragent, Date rkoDate, BigDecimal usdAmount,
               BigDecimal uahAmount, BigDecimal euroAmount, BigDecimal rkoAmount,
               Float euroUsdKurs, Float usdUahKurs, String comments) {
        this.contragent = contragent;
        this.rkoDate = rkoDate;
        this.usdAmount = usdAmount;
        this.uahAmount = uahAmount;
        this.euroAmount = euroAmount;
        this.rkoAmount = rkoAmount;
        this.EuroUsdKurs = euroUsdKurs;
        this.UsdUahKurs = usdUahKurs;
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

    public PaymentOperation getPaymentOperation() {
        return paymentOperation;
    }

    public void setPaymentOperation(PaymentOperation paymentOperation) {
        this.paymentOperation = paymentOperation;
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

    public int getRkoid() {
        return rkoid;
    }

    public void setRkoid(int rkoid) {
        this.rkoid = rkoid;
    }

    public Float getEuroUsdKurs() {
        return EuroUsdKurs;
    }

    public void setEuroUsdKurs(Float euroUsdKurs) {
        EuroUsdKurs = euroUsdKurs;
    }

    public Float getUsdUahKurs() {
        return UsdUahKurs;
    }

    public void setUsdUahKurs(Float usdUahKurs) {
        UsdUahKurs = usdUahKurs;
    }

    @Override
    public String toString() {
        return "Rko{" +
                "id=" + id +
                ", rkoid=" + rkoid +
                ", paymentType=" + paymentType +
                ", paymentOperation=" + paymentOperation +
                ", contragent=" + contragent +
                ", rkoDate=" + rkoDate +
                ", insertDate=" + insertDate +
                ", managerName='" + managerName + '\'' +
                ", usdAmount=" + usdAmount +
                ", uahAmount=" + uahAmount +
                ", euroAmount=" + euroAmount +
                ", rkoAmount=" + rkoAmount +
                ", EuroUsdKurs=" + EuroUsdKurs +
                ", UsdUahKurs=" + UsdUahKurs +
                ", comments='" + comments + '\'' +
                '}';
    }
}

