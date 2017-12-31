package com.eco.sklad.DTO;

import com.eco.sklad.domain.Contragent;
import com.eco.sklad.domain.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceDTO {
    private int id;
    private Date orderDate;
    private int contragentId;
    private int invoiceId;
    private String contragentName;
    private BigDecimal orderDiscount = new BigDecimal("0");
    private BigDecimal orderFee = new BigDecimal("0");
    private BigDecimal totalOrder = new BigDecimal("0");
    private Boolean finalized=false;
    private User salesManager=new User();
    private List<InvoiceLineDTO> invoiceLinesDTOList = new ArrayList<>();

    public InvoiceDTO() {
    }

    public InvoiceDTO(int id, int contragentId, String contragentName, BigDecimal totalOrder) {
        this.id = id;
        this.contragentId = contragentId;
        this.contragentName = contragentName;
        this.totalOrder = totalOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public InvoiceDTO(int contragentId) {
        this.contragentId = contragentId;
    }

    public int getContragentId() {
        return contragentId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setContragentId(int contragentId) {
        this.contragentId = contragentId;
    }


    public String getContragentName() {
        return contragentName;
    }

    public void setContragentName(String contragentName) {
        this.contragentName = contragentName;
    }

    public BigDecimal getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(BigDecimal orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public BigDecimal getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(BigDecimal orderFee) {
        this.orderFee = orderFee;
    }

    public BigDecimal getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(BigDecimal totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Boolean getFinalized() {
        return finalized;
    }

    public void setFinalized(Boolean finalized) {
        this.finalized = finalized;
    }

    public User getSalesManager() {
        return salesManager;
    }

    public void setSalesManager(User salesManager) {
        this.salesManager = salesManager;
    }

    public List<InvoiceLineDTO> getInvoiceLinesDTOList() {
        return invoiceLinesDTOList;
    }

    public void setInvoiceLinesDTOList(List<InvoiceLineDTO> invoiceLinesDTOList) {
        this.invoiceLinesDTOList = invoiceLinesDTOList;
    }

    public void addInvoiceLineDTO(InvoiceLineDTO invoiceLineDTO){
        this.invoiceLinesDTOList.add(invoiceLineDTO);
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", contragentId=" + contragentId +
                ", contragentName='" + contragentName + '\'' +
                ", orderDiscount=" + orderDiscount +
                ", orderFee=" + orderFee +
                ", totalOrder=" + totalOrder +
                ", finalized=" + finalized +
                ", salesManager=" + salesManager +
                ", invoiceLinesDTOList=" + invoiceLinesDTOList +
                '}';
    }
}
