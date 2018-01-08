package com.eco.sklad.repository;

import com.eco.sklad.domain.Rko;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RKORepository extends JpaRepository<Rko, Integer> {

//        @Query("from Supplies u where u.shortName=:shortName")
//        Optional<Product> findByShortName(@Param("shortName") String shortName);

        Rko save(Rko rko);

//        @Query(value = "SELECT LAST_INSERT_ID() FROM ", nativeQuery = true)
//        User findByEmailAddress(String emailAddress);



}
