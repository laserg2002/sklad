package com.eco.sklad.service;

import com.eco.sklad.domain.Journal;
import com.eco.sklad.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    @Autowired
    JournalRepository journalRepo;

    public List<Journal> findAll(){
        return journalRepo.findAll();
    }

}
