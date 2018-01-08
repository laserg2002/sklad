package com.eco.sklad.service;

import com.eco.sklad.domain.Pko;
import com.eco.sklad.repository.PKORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PKOService {


    @Autowired
    PKORepository pkoRepo;

//    public List<Pko> findAll(){
//        return pkoRepo.findAll();
//    }

    public List<Pko> findAllDesc(){
        return pkoRepo.findAllOrderByIdDesc();
    }

    public List<Pko> findAllByManager(){
        return pkoRepo.findAllByManager(SecurityContextHolder.getContext().getAuthentication().getName());
    }



    @Transactional
    public void savePko(Pko pko){
        System.out.println(pko);
        pkoRepo.save(pko);
    }

    public Pko findOne (Integer id){
        return pkoRepo.findOne(id);
    }

    @Transactional
    public boolean delete(int id){
        pkoRepo.delete(id);
        return true;
    }
}
