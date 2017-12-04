package com.eco.sklad.service;

import com.eco.sklad.domain.SupplyLines;
import com.eco.sklad.repository.SupplyLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplyLinesService {
    @Autowired
    SupplyLinesRepository supplyLinesRepo;

    public List<SupplyLines> findAll(){
        return supplyLinesRepo.findAll();
    }

    @Transactional
    public void addSupplyLines(SupplyLines supplyLines){
        supplyLinesRepo.save(supplyLines);
    }

    public SupplyLines findOne (Integer id){

        return supplyLinesRepo.findOne(id);
    }

    @Transactional
    public boolean delete(int id){
        supplyLinesRepo.delete(id);
        return true;
    }
}
