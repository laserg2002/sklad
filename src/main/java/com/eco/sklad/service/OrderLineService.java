package com.eco.sklad.service;

import com.eco.sklad.domain.OrderLines;
import com.eco.sklad.repository.OrderLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderLineService {
    @Autowired
    OrderLinesRepository orderLinesRepo;


    public List<OrderLines> findAll(){
        return orderLinesRepo.findAll();
    }

    @Transactional
    public void addSupplyLines(OrderLines orderLines){
        orderLinesRepo.save(orderLines);
    }

    public OrderLines findOne (Integer id){

        return orderLinesRepo.findOne(id);
    }

    @Transactional
    public boolean delete(int id){
        orderLinesRepo.delete(id);
        return true;
    }



}

