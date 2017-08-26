package com.eco.sklad.repository;

import com.eco.sklad.domain.Country;
import com.eco.sklad.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Override
    List<Country> findAll();

    Country findById(Integer id);
}
