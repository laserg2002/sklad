package com.eco.sklad.web;

import com.eco.sklad.DTO.PersonDTO;
import com.eco.sklad.domain.Person;
import com.eco.sklad.domain.User;
import com.eco.sklad.repository.AddressRepository;
import com.eco.sklad.repository.EmailRepository;
import com.eco.sklad.repository.PhoneRepository;
import com.eco.sklad.service.PersonService;
import com.eco.sklad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/user")
public class UserController {

        @Autowired
        UserService userService;

        @GetMapping
        public String showAllUsers(Person person, Model model) {
            model.addAttribute("userlist", userService.findAll());
            return "user/userlist";
        }

        @RequestMapping("/edit/{id}")
        public String showUserForm(@PathVariable("id") Integer id, ModelMap model) {
            User user = userService.findOne(id);
            model.addAttribute("user", user);
            return "user/userform";
        }

        @GetMapping("/new")
        public String addNewUser( ModelMap model) {
            model.addAttribute("user", new PersonDTO());
            return "user/userform";
        }

        @RequestMapping(value="/add", method = RequestMethod.POST)
        public String addNewUserPost(@Valid @ModelAttribute User user, BindingResult bindingResult) {
            userService.addUser(user);
            return "user/userlist";
        }
        @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
        public String deleteUser(@PathVariable int id, ModelMap model) {
            userService.delete(id);
            return "user/userlist";
        }

}
