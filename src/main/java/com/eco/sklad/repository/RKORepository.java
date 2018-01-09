package com.eco.sklad.repository;

import com.eco.sklad.domain.Pko;
import com.eco.sklad.domain.Rko;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RKORepository extends JpaRepository<Rko, Integer> {

//        @Query("from Supplies u where u.shortName=:shortName")
//        Optional<Product> findByShortName(@Param("shortName") String shortName);

        Rko save(Rko rko);

        @Query(value = "SELECT * FROM rko ORDER BY id DESC", nativeQuery = true)
        List<Rko> findAllOrderByIdDesc();

        @Query(value = "SELECT * FROM rko WHERE manager_name=?1 ORDER BY id DESC", nativeQuery = true)
        List<Rko> findAllByManager(String managerName);

//        @Query(value = "SELECT LAST_INSERT_ID() FROM ", nativeQuery = true)
//        User findByEmailAddress(String emailAddress);



}
