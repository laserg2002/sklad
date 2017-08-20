package com.eco.sklad.repository;

import com.eco.sklad.domain.Phone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    @Modifying
    @Query(value = "insert into phone (person_id_person, phone, viber) VALUES (?1, ?2, ?3)",
            nativeQuery = true)
    void addPhone(int id, String phoneNumber, boolean viber);

    @Query(value = "select person_id_person from phone where phone = ?1",
            nativeQuery = true)
    int findPhone(String phoneNumber);
}
