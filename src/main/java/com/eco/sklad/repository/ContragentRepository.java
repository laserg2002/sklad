package com.eco.sklad.repository;

import com.eco.sklad.domain.Contragent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

    public interface ContragentRepository extends JpaRepository<Contragent, Integer>{

        @Query("from Contragent u where u.balansName=:balansName")

        Optional<Contragent> findByBalansName(@Param("balansName") String balansName);

        Contragent save(Contragent contragent);

//        @Modifying
//        @Query(value = "insert into person (name, last_name) VALUES (?1, ?2)", nativeQuery = true)
//        void addPerson(String name, String lastName);        Contragent add(Contragent contragent);

}
