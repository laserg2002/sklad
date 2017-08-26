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
import java.util.Iterator;
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

        int id;
        if (personDTO.getId()==null) {
            personRe.addPerson(personDTO.getName(), personDTO.getLastName());
            id = personRe.findByNameAndLastName(personDTO.getName(), personDTO.getLastName());
        }   else {
            id = personDTO.getId();
            personRe.updatePerson(id,personDTO.getName(), personDTO.getLastName());
            emailRe.delete(id);
            phoneRe.delete(id);
            addressRe.delete(id);
        }
            addressRe.addAddress(id, personDTO.getCity(), personDTO.getRegion(),
                    personDTO.getStreet(), personDTO.getComment());
            emailRe.addEmail(id, personDTO.getEmail1());
            if (!personDTO.getEmail2().isEmpty()) {
                emailRe.addEmail(id, personDTO.getEmail2());
            }
            if (!personDTO.getPhone1().isEmpty()) {
                phoneRe.addPhone(id, personDTO.getPhone1(), personDTO.getViber1());
            }
            if (!personDTO.getPhone2().isEmpty()) {
                phoneRe.addPhone(id, personDTO.getPhone2(), personDTO.getViber2());
            }
            return personRe.findByIdPerson(id);

    }
    public List<Person> findAll(){
        return personRe.findAll();
    }

//    public Person findByLastName(String fullName){
//        return PerRepo.findByLastName(fullName);
//    }

    public PersonDTO findOne (Integer id){
        Person person = personRe.findByIdPerson(id);
        System.out.println(person);
        List<Phone> phoneList = phoneRe.findTwo(id);
        List<Email> emailList = emailRe.findTwo(id);
        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(person.getIdPerson());
        personDTO.setName(person.getName());
        personDTO.setLastName(person.getLastName());
        personDTO.setRegion(person.getAddress().getRegion());
        personDTO.setCity(person.getAddress().getCityName());
        personDTO.setStreet(person.getAddress().getStreet());
        personDTO.setComment(person.getAddress().getComment());
        Iterator<Phone> phoneIterator = phoneList.iterator();
        if (phoneIterator.hasNext()) {
            Phone phone1 = phoneIterator.next();
            personDTO.setPhone1(phone1.getPhone());
            personDTO.setViber1(phone1.isViber());
        }
        if (phoneIterator.hasNext()) {
            Phone phone2 = phoneIterator.next();
            personDTO.setPhone2(phone2.getPhone());
            personDTO.setViber2(phone2.isViber());
        }
        Iterator<Email> emailIterator = emailList.iterator();
        if (emailIterator.hasNext()) {
            personDTO.setEmail1(emailIterator.next().getEmail());
            if (emailIterator.hasNext()) {
                personDTO.setEmail2(emailIterator.next().getEmail());
            }
        }
        return personDTO;
    }

//    void addPerson(Person person){
//        PerRepo.addPerson(person);
//    }

//    void savePerson(Person person){
//        PerRepo.savePerson(person);
//    }
    public boolean delete(int id){
        if(true){
            emailRe.delete(id);
            phoneRe.delete(id);
            addressRe.delete(id);
            personRe.delete(id);
        }
        return true;
    }

}
