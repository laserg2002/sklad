package com.eco.sklad.service;

import com.eco.sklad.domain.Producer;
import com.eco.sklad.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    @Autowired
    ProducerRepository producerRepo;

    public List<Producer> findAll(){
        return producerRepo.findAll();
    }


}
