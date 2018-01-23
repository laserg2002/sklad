package com.eco.sklad.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JournalKeyId implements Serializable {

    @Column(name = "doc_id", nullable = false)
    private int docId;

    @Column(name = "doc", nullable = false)
    private String doc;

    public JournalKeyId(int docId, String doc) {
        this.docId = docId;
        this.doc = doc;
    }

    public JournalKeyId() {
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDoc() {
        switch (this.doc.trim()) {
            case "PN" : return "Прихідна накладна";
            case "PK" : return "Прихідний касовий ордер";
            case "RK" : return "Розхідний касовий ордер";
            case "VN" : return "Видаткова накладна";
            default:
        return doc;
    }}

    public void setDoc(String doc) {
        this.doc = doc;
    }

    @Override
    public String toString() {
        return doc.trim()+docId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JournalKeyId)) return false;

        JournalKeyId that = (JournalKeyId) o;

        if (docId != that.docId) return false;
        return doc.equals(that.doc);
    }

    @Override
    public int hashCode() {
        int result = docId;
        result = 31 * result + doc.hashCode();
        return result;
    }
}
