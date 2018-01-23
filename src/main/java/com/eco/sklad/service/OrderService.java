package com.eco.sklad.service;

import com.eco.sklad.domain.Contragent;
import com.eco.sklad.domain.Order;
import com.eco.sklad.domain.OrderLines;
import com.eco.sklad.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;

    @Autowired
    OrderLinesRepository orderLinesRepo;

//    @Autowired
//    ContragentRepository contragentRepo;
//
//    @Autowired
//    ProductRepository productRepo;

    public List<Order> findAll(){
        return orderRepo.findAll();
    }

    @Transactional
    public void addOrder(Order order){
        order.setTotalOrder(order.calculateTotal());
        orderRepo.save(order);
}

    public Order findOne (Integer id){
        return orderRepo.findOne(id);
    }

    @Transactional
    public boolean delete(int id){
        orderRepo.delete(id);
        return true;
    }
}

