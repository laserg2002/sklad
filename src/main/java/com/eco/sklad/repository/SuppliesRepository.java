package com.eco.sklad.repository;

import com.eco.sklad.domain.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SuppliesRepository extends JpaRepository<Supplies, Integer> {

//        @Query("from Supplies u where u.shortName=:shortName")
//        Optional<Product> findByShortName(@Param("shortName") String shortName);

        Supplies save(Supplies supplies);

}
