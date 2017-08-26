package com.eco.sklad.repository;

import com.eco.sklad.domain.Person;
import com.eco.sklad.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Override
    List<Person> findAll();

    @Override
    Person save(Person person);

    @Modifying
    @Query(value = "insert into person (name, last_name) VALUES (?1, ?2)", nativeQuery = true)
    void addPerson(String name, String lastName);

    @Modifying
    @Query(value = "UPDATE person set name=?2, last_name=?3 WHERE id_person = ?1", nativeQuery = true)
    void updatePerson(Integer id, String name, String lastName);


    @Query(value = "select id_person from person where name = ?1 and last_name = ?2", nativeQuery = true)
    int findByNameAndLastName(String name, String lastName);

    Person findByIdPerson(Integer id);

    @Modifying
    @Query(value = "delete from person where id_person=?1", nativeQuery = true)
    void delete(Integer ids);

//    Person findByEmail(Integer id);

//    @Modifying
//    @Transactional
//    void addPerson(Person person);

//    @Modifying
//    @Transactional
//    void savePerson(Person person);

}
