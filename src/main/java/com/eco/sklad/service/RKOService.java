package com.eco.sklad.service;

import com.eco.sklad.domain.Rko;
import com.eco.sklad.repository.RKORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RKOService {



    @Autowired
    RKORepository rkoRepo;

//    public List<Pko> findAll(){
//        return pkoRepo.findAll();
//    }

    public List<Rko> findAllDesc(){
        return rkoRepo.findAllOrderByIdDesc();
    }

    public List<Rko> findAllByManager(){
        return rkoRepo.findAllByManager(SecurityContextHolder.getContext().getAuthentication().getName());
    }



    @Transactional
    public void saveRko(Rko rko){
        System.out.println(rko);
        rkoRepo.save(rko);
    }

    public Rko findOne (Integer id){
        return rkoRepo.findOne(id);
    }

    @Transactional
    public boolean delete(int id){
        rkoRepo.delete(id);
        return true;
    }
}
