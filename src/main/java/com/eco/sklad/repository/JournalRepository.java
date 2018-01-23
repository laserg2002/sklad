package com.eco.sklad.repository;

import com.eco.sklad.domain.Journal;
import com.eco.sklad.domain.JournalKeyId;
import com.eco.sklad.domain.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, JournalKeyId> {

//        Optional<Product> findByShortName(@Param("shortName") String shortName);
//        @Query(value = "SELECT LAST_INSERT_ID() FROM ", nativeQuery = true)
//        User findByEmailAddress(String emailAddress);

}
