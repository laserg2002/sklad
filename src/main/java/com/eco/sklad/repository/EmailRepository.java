package com.eco.sklad.repository;

import com.eco.sklad.domain.Email;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Integer> {

    @Modifying
    @Query(value = "insert into email (person_id_person, e_mail) VALUES (?1, ?2)",
            nativeQuery = true)
    void addEmail(int id, String email);

    @Query(value = "select person_id_person from email where e_mail = ?1",
            nativeQuery = true)
    int findEmail(String email);
}

