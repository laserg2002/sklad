package com.eco.sklad.service;

import com.eco.sklad.DTO.PersonDTO;
import com.eco.sklad.domain.Address;
import com.eco.sklad.domain.Email;
import com.eco.sklad.domain.Person;
import com.eco.sklad.domain.Phone;
import com.eco.sklad.repository.AddressRepository;
import com.eco.sklad.repository.EmailRepository;
import com.eco.sklad.repository.PersonRepository;
import com.eco.sklad.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRe;
    @Autowired
    PhoneRepository phoneRe;
    @Autowired
    EmailRepository emailRe;
    @Autowired
    AddressRepository addressRe;


    @Transactional
    public Person addPerson(PersonDTO personDTO) {
        personRe.addPerson(personDTO.getName(), personDTO.getLastName());
        int id = personRe.findByNameAndLastName(personDTO.getName(), personDTO.getLastName());
        addressRe.addAddress(id, personDTO.getCity(),personDTO.getPostIndex(),
                personDTO.getStreet(), personDTO.getComment());
        emailRe.addEmail(id, personDTO.getEmail1());
        if (personDTO.getEmail2() != null) {emailRe.addEmail(id, personDTO.getEmail2());}
        phoneRe.addPhone(id, personDTO.getPhone1(), true);
//                ,personDTO.getViber1());
        if (personDTO.getPhone2() != null) {phoneRe.addPhone(id, personDTO.getPhone2(),true);}
//                personDTO.getViber2());}
        return personRe.findByIdPerson(id);
    }

    public List<Person> findAll(){
        return personRe.findAll();
    }

//    public Person findByLastName(String fullName){
//        return PerRepo.findByLastName(fullName);
//    }

    Person findByIdPerson(Integer id){
     return personRe.findByIdPerson(id);
    }

//    void addPerson(Person person){
//        PerRepo.addPerson(person);
//    }

//    void savePerson(Person person){
//        PerRepo.savePerson(person);
//    }

}
