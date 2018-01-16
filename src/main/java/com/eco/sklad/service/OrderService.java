package com.eco.sklad.service;

import com.eco.sklad.domain.Contragent;
import com.eco.sklad.domain.Order;
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

    //    @Autowired
//    SupplyLinesRepository suppliesLinesRepo;

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
//        Contragent contragent = contragentRepo.findOne(invoiceDTO.getContragentId());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String managerName=authentication.getName();
//        Supplies supplies = new Supplies(invoiceDTO.getInvoiceId(), invoiceDTO.getOrderDate(),
//                contragent,
//                invoiceDTO.getTotalOrder(),
//                managerName
//        );
//        if (supplies.getId()>0) {
//            System.out.println(supplies);
//            List<SupplyLines> newList = new ArrayList<>();
//            BigDecimal total = new BigDecimal(0);
//            for (InvoiceLineDTO invoiceLineDTO:invoiceLineDTOS
//                    ) {
//                SupplyLines supplyLine = new SupplyLines( supplies,
//                        productRepo.findOne(invoiceLineDTO.getProductId()),
//                        invoiceLineDTO.getQuantity(),
//                        invoiceLineDTO.getPrice());
//                total = total.add(invoiceLineDTO.getItemTotal());
//                newList.add(supplyLine);
//            }
//            supplies.setTotal(total);
//            supplies.setSupplyList(newList);
//            suppliesRepo.save(supplies);
//        } else {
//
//            Supplies supplies1 = suppliesRepo.save(supplies);
//
//            BigDecimal total = new BigDecimal(0);
//            for (InvoiceLineDTO invoiceLineDTO:invoiceLineDTOS
//                    ) {
//                SupplyLines supplyLine = new SupplyLines( supplies1,
//                        productRepo.findOne(invoiceLineDTO.getProductId()),
//                        invoiceLineDTO.getQuantity(),
//                        invoiceLineDTO.getPrice());
//                suppliesLinesRepo.save(supplyLine);
//                total = total.add(invoiceLineDTO.getItemTotal());
//            }
//            supplies1.setTotal(total);
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

