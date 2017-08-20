package com.eco.sklad.repository;

import com.eco.sklad.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer>{

    @Modifying
    @Query(value = "insert into address (id_owner, city_name, post_index, street_address, comment) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void addAddress(int id, String city, String index, String street, String comment);
}
