package com.eco.sklad.service;

import com.eco.sklad.DTO.InvoiceDTO;
import com.eco.sklad.DTO.InvoiceLineDTO;
import com.eco.sklad.domain.Contragent;
import com.eco.sklad.domain.Product;
import com.eco.sklad.domain.Supplies;
import com.eco.sklad.domain.SupplyLines;
import com.eco.sklad.repository.ContragentRepository;
import com.eco.sklad.repository.ProductRepository;
import com.eco.sklad.repository.SuppliesRepository;
import com.eco.sklad.repository.SupplyLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliesService {
    @Autowired
    SuppliesRepository suppliesRepo;
    @Autowired
    SupplyLinesRepository suppliesLinesRepo;
    @Autowired
    ContragentRepository contragentRepo;
    @Autowired
    ProductRepository productRepo;

    public List<Supplies> findAll(){
        return suppliesRepo.findAll();
    }

    @Transactional
    public void addSupply(InvoiceDTO invoiceDTO, ArrayList<InvoiceLineDTO> invoiceLineDTOS){
        Contragent contragent = contragentRepo.findOne(invoiceDTO.getContragentId());
        Supplies supplies = new Supplies(invoiceDTO.getOrderDate(), contragent,
                invoiceDTO.getTotalOrder());
        System.out.println(invoiceDTO);
        System.out.println(supplies);
        Supplies supplies1 = suppliesRepo.save(supplies);

        BigDecimal total = new BigDecimal(0);
        for (InvoiceLineDTO invoiceLineDTO:invoiceLineDTOS
                ) {
            SupplyLines supplyLine = new SupplyLines( supplies1,
                    productRepo.findOne(invoiceLineDTO.getProductId()),
                    invoiceLineDTO.getQuantity(),
                    invoiceLineDTO.getPrice());
            suppliesLinesRepo.save(supplyLine);
            total = total.add(invoiceLineDTO.getItemTotal());
        }
        supplies1.setTotal(total);
        suppliesRepo.save(supplies1);
    }

    public Supplies findOne (Integer id){
        return suppliesRepo.findOne(id);
    }

    @Transactional
    public boolean delete(int id){
        suppliesRepo.delete(id);
        return true;
    }
}
