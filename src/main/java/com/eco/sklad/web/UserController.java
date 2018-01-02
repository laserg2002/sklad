package com.eco.sklad.web;

import com.eco.sklad.DTO.PersonDTO;
import com.eco.sklad.DTO.UserDTO;
import com.eco.sklad.domain.Contragent;
import com.eco.sklad.domain.Person;
import com.eco.sklad.domain.User;
import com.eco.sklad.repository.AddressRepository;
import com.eco.sklad.repository.EmailRepository;
import com.eco.sklad.repository.PhoneRepository;
import com.eco.sklad.service.PersonService;
import com.eco.sklad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            return "users/userlist";
        }

        @RequestMapping("/edit/{id}")
        public String showUserForm(@PathVariable("id") Integer id, ModelMap model) {
            User user = userService.findOne(id);
            model.addAttribute("user", user);
            return "users/userform";
        }

        @GetMapping("/new")
        public String addNewUser( ModelMap model) {
            model.addAttribute("user", new User());
            return "users/userform";
        }

        @GetMapping("/newcontragent")
        public String addNewContragent( ModelMap model) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String managerName=authentication.getName();
            model.addAttribute("user", new User(new Contragent(managerName)));
            return "users/contragentform";
        }

        @RequestMapping(value="/addcontragent", method = RequestMethod.POST)
        public String addNewContragentPost(@Valid @ModelAttribute User contragent, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "/users/contragentform";
            }
            System.out.println("ffffff"+contragent);
            userService.addContragent(contragent);
            return "users/userlist";
        }

        @RequestMapping(value="/add", method = RequestMethod.POST)
        public String addNewUserPost(@Valid @ModelAttribute User user, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "/users/userform";
            }
            userService.addUser(user);
            return "users/userlist";
        }
        @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
        public String deleteUser(@PathVariable int id, ModelMap model) {
            userService.delete(id);
            return "users/userlist";
        }

}
