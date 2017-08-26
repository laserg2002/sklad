package com.eco.sklad.repository;

import com.eco.sklad.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
    @Override
    List<Producer> findAll();

    Producer findByFullName(String fullName);

    Producer findByIdPr(Integer idPr);

    @Modifying
    @Transactional
    @Query(value = "insert into producer (full_name, pr_category, country_id) VALUES (?1, ?2, ?3)",
            nativeQuery = true)
    void addProducer(String fullName, String categoryProducer, int country);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producer set pr_category=?2, country_id=?3 WHERE id_pr=?1",
            nativeQuery = true)
    void updateProducer(  int idPr, String categoryProducer, int country);


}