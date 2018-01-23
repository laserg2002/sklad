package com.eco.sklad.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
public class Journal {

    @EmbeddedId
    private JournalKeyId journalKeyId;

    @Column(name = "dat")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "debet")
    private double debet;

    @ManyToOne
    private Contragent contragent;

    @Column(name = "manager_name")
    private String managerName;

    public Journal(JournalKeyId journalKeyId, Date date, double debet, Contragent contragent, String managerName) {
        this.journalKeyId = journalKeyId;
        this.date = date;
        this.debet = debet;
        this.contragent = contragent;
        this.managerName = managerName;
    }

    public Journal() {
    }

    public JournalKeyId getJournalKeyId() {
        return journalKeyId;
    }

    public void setJournalKeyId(JournalKeyId journalKeyId) {
        this.journalKeyId = journalKeyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDebet() {
        return debet;
    }

    public void setDebet(double debet) {
        this.debet = debet;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
