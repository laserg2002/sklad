package com.eco.sklad.web;

import com.eco.sklad.DTO.PersonDTO;
import com.eco.sklad.domain.Person;
import com.eco.sklad.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value="/person")
public class PersonControler {
    @Autowired
    PersonService personService;

    @GetMapping
    public String showAllPersons(Person person, Model model) {
        model.addAttribute("personlist", personService.findAll());
        return "person/personlist";
    }

    @RequestMapping("/{idPerson}")
    public String showUserForm(@PathVariable("idPerson") Person person, Model model) {
        model.addAttribute("person", person);
        return "person/personform";
    }

    @GetMapping("/new")
    public String addUserForm( Model model) {
        model.addAttribute("personDTO", new PersonDTO());
        return "person/personform";
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute PersonDTO personDTO) {
        personService.addPerson(personDTO);
        return "person/personlist";
    }




//    @RequestMapping(value = "/persons", method = RequestMethod.GET)
//    ResponseEntity persons(Pageable pageable,
//                                               PagedResourcesAssembler assembler) {
//
//        Page<Person> persons = personService.findAll(pageable);
//        return new ResponseEntity<>(assembler.toResources(persons), HttpStatus.OK);
//    }



}
