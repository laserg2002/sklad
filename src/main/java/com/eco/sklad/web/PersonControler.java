package com.eco.sklad.web;

import com.eco.sklad.DTO.PersonDTO;
import com.eco.sklad.domain.Person;
import com.eco.sklad.repository.AddressRepository;
import com.eco.sklad.repository.EmailRepository;
import com.eco.sklad.repository.PhoneRepository;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value="/person")
public class PersonControler {
    @Autowired
    PersonService personService;
    @Autowired
    AddressRepository addressRe;
    @Autowired
    PhoneRepository phoneRe;
    @Autowired
    EmailRepository emailRe;


    @GetMapping
    public String showAllPersons(Person person, Model model) {
        model.addAttribute("personlist", personService.findAll());
        return "person/personlist";
    }

    @RequestMapping("/edit/{idPerson}")
    public String showUserForm(@PathVariable("idPerson") Integer id, ModelMap model) {
        PersonDTO personDTO = personService.findOne(id);
        model.addAttribute("personDTO", personDTO);
        System.out.println(personDTO);
        return "person/personform";
    }


    @GetMapping("/new")
    public String addUserForm( ModelMap model) {
        model.addAttribute("personDTO", new PersonDTO());
        return "person/personform";
    }


    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addUserPost(@Valid @ModelAttribute PersonDTO personDTO, BindingResult bindingResult) {
        System.out.println(personDTO);
        if (personDTO.getId()==null) {
            if (!personDTO.getPhone1().trim().isEmpty()) {
                if (phoneRe.existsByPhone(personDTO.getPhone1())) {
                    bindingResult.addError(new ObjectError("phone1", "phone already exists for this email."));
                }
            }
            if (!personDTO.getPhone2().trim().isEmpty()) {
                if (phoneRe.existsByPhone(personDTO.getPhone2())) {
                    bindingResult.addError(new ObjectError("phone2", "phone already exists for this email."));
                }
            }
            if (!personDTO.getEmail1().trim().isEmpty()) {
//            if (emailRe.findByEmail(personDTO.getEmail1()) != null) {
                if (emailRe.existsByEmail(personDTO.getEmail1())) {
                    bindingResult.addError(new ObjectError("email1", "email1 already exists for this email."));
                }
            }
            if (!personDTO.getEmail2().trim().isEmpty()) {
                if (emailRe.existsByEmail(personDTO.getEmail2())) {
                    bindingResult.addError(new ObjectError("email2", "email2 already exists for this email."));
                }
            }
        }
        if (bindingResult.hasErrors()) {
            return "person/personform";
        }
        personService.addPerson(personDTO);
        return "person/personlist";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        boolean wasOk = personService.delete(id);
        if (wasOk) {
            return "person/personlist";
        }
        return "person/personlist";
    }


}
