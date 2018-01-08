package com.eco.sklad.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Pko {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int pkoid=0;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    private CassaOperation cassaOperation;

    @ManyToOne
    @JoinColumn(name = "contragent_id")
    private Contragent contragent;

    @Temporal(TemporalType.DATE)
    private Date pkoDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    private String managerName;

    private BigDecimal usdAmount = new BigDecimal(0);
    private BigDecimal uahAmount = new BigDecimal(0);
    private BigDecimal euroAmount = new BigDecimal(0);
    @Generated( value = GenerationTime.ALWAYS )
    private BigDecimal pkoAmount;
    private Float euroUsdKurs = 1.22f;
    private Float usdUahKurs = 28.1f;
    private String comments;

    public Pko() {
    }

    public Pko(Contragent contragent, Date pkoDate, BigDecimal usdAmount,
               BigDecimal uahAmount, BigDecimal euroAmount, BigDecimal pkoAmount,
               Float euroUsdKurs, Float usdUahKurs, String comments) {
        this.contragent = contragent;
        this.pkoDate = pkoDate;
        this.usdAmount = usdAmount;
        this.uahAmount = uahAmount;
        this.euroAmount = euroAmount;
        this.pkoAmount = pkoAmount;
        this.euroUsdKurs = euroUsdKurs;
        this.usdUahKurs = usdUahKurs;
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

    public Integer getPkoid() {
        return pkoid;
    }

    public void setPkoid(int pkoid) {
        this.pkoid = pkoid;
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

    public Float getEuroUsdKurs() {
        return euroUsdKurs;
    }

    public void setEuroUsdKurs(Float euroUsdKurs) {
        this.euroUsdKurs = euroUsdKurs;
    }

    public Float getUsdUahKurs() {
        return usdUahKurs;
    }

    public void setUsdUahKurs(Float usdUahKurs) {
        this.usdUahKurs = usdUahKurs;
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

    @Override
    public String toString() {
        return "Pko{" +
                "id=" + id +
                "pkoid=" + pkoid +
                ", paymentType=" + paymentType +
                ", cassaOperation=" + cassaOperation +
                ", contragent=" + contragent +
                ", pkoDate=" + pkoDate +
                ", insertDate=" + insertDate +
                ", managerName='" + managerName + '\'' +
                ", usdAmount=" + usdAmount +
                ", uahAmount=" + uahAmount +
                ", euroAmount=" + euroAmount +
                ", pkoAmount=" + pkoAmount +
                ", euroUsdKurs=" + euroUsdKurs +
                ", usdUahKurs=" + usdUahKurs +
                ", comments='" + comments + '\'' +
                '}';
    }
}

