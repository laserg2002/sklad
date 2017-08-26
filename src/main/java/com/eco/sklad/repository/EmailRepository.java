package com.eco.sklad.repository;

import com.eco.sklad.domain.Email;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailRepository extends CrudRepository<Email, Integer> {

    @Query(value = "select * from email where person_id_person = ?1", nativeQuery = true)
    List<Email> findTwo(Integer id);

    @Modifying
    @Query(value = "insert into email (person_id_person, e_mail) VALUES (?1, ?2)",
            nativeQuery = true)
    void addEmail(int id, String email);

    @Query(value = "select person_id_person from email where e_mail = ?1",
            nativeQuery = true)
    Integer findByEmail(String email);

    @Override
    Email findOne(Integer integer);

    boolean existsByEmail(String email);

    @Modifying
    @Query(value = "delete from email where person_id_person= ?1", nativeQuery = true)
    void delete(Integer ids);

}

