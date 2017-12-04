package com.eco.sklad.service;

import com.eco.sklad.domain.Contragent;
import com.eco.sklad.domain.Product;
import com.eco.sklad.repository.ContragentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContragentService {

        @Autowired
        ContragentRepository contragentRepo;

        public List<Contragent> findAll(){
            return contragentRepo.findAll();
        }

        @Transactional
        public void addContragent(Contragent contragent){
            contragentRepo.save(contragent);
        }

        public Contragent findOne (Integer id){

            return contragentRepo.findOne(id);
        }

        @Transactional
        public boolean delete(int id){
            contragentRepo.delete(id);
            return true;
        }
    }

