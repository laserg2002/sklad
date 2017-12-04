package com.eco.sklad.service;

import com.eco.sklad.domain.Contragent;
import com.eco.sklad.domain.Supplies;
import com.eco.sklad.repository.ContragentRepository;
import com.eco.sklad.repository.SuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuppliesService {
    @Autowired
    SuppliesRepository suppliesRepo;

    public List<Supplies> findAll(){
        return suppliesRepo.findAll();
    }

    @Transactional
    public void addSupply(Supplies supplies){
        suppliesRepo.save(supplies);
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
