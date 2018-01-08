package com.eco.sklad.repository;

import com.eco.sklad.domain.Pko;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PKORepository extends CrudRepository<Pko, Integer> {

//        @Query("from Supplies u where u.shortName=:shortName")
//        Optional<Product> findByShortName(@Param("shortName") String shortName);

    Pko save(Pko pko);

    @Query(value = "SELECT * FROM pko ORDER BY id DESC", nativeQuery = true)
    List<Pko> findAllOrderByIdDesc();

    @Query(value = "SELECT * FROM pko WHERE manager_name=?1 ORDER BY id DESC", nativeQuery = true)
    List<Pko> findAllByManager(String managerName);
}
