package com.eco.sklad.domain;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    @ManyToOne
    private Contragent customer;

    private BigDecimal totalOrder;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="order_id")
    private List<OrderLines> orderLines = new ArrayList<>();

    private String managerName;


    public Order() {
    }


    public void addOrderLines(OrderLines orderLine) {
        Set<OrderLines> dtoSet = new HashSet<>(this.orderLines);
        dtoSet.add(orderLine);
        this.orderLines=new ArrayList<>(dtoSet);
    }

    public void removeOrderLine(int lineNumber){
        this.orderLines.remove(lineNumber);
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = new BigDecimal(0);
            if (!orderLines.isEmpty()){
                for (OrderLines line: orderLines) {
                    total=total.add(line.getTotal());
                }
            }
        return total;
    }


//    public Boolean getFinalized() {
//        return finalized;
//    }
//
//    public void setFinalized(Boolean finalized) {
//        this.finalized = finalized;
//    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Contragent getCustomer() {
        return customer;
    }

    public void setCustomer(Contragent customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(BigDecimal totalOrder) {
        this.totalOrder = totalOrder;
    }

    public List<OrderLines> getOrderLines() {
        return orderLines;
    }

//    public OrderLines getOrderLine() {
//
//        return orderLines;
//    }


    public void setOrderLines(List<OrderLines> orderLines) {
        this.orderLines = orderLines;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customer=" + customer.getId() +
                ", totalOrder=" + totalOrder +
                ", orderLines=" + orderLines.size() +
                ", salesManager=" + managerName +
                '}';
    }
}
