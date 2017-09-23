package com.eco.sklad.web;

import com.eco.sklad.DTO.PersonDTO;
import com.eco.sklad.domain.User;
import com.eco.sklad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userServise;

    @RequestMapping("/")
    public  String getMainPage(){
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required=false) String error,
                           @RequestParam(value = "logout", required=false) String logout,
                           Model model)
//            , Principal principal)
 {
        model.addAttribute("error", error!=null);
        model.addAttribute("logout", logout!=null);
//        model.addAttribute("user", principal);
        return "login";
    }

    @GetMapping("/registration")
    public  String registr(ModelMap model) {
        model.addAttribute("user", new User());
        return "registration";
    }
    @RequestMapping(value="/registr", method = RequestMethod.POST)
    public String registrUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        System.out.println(user);
        if (user.getId()==null) {
            if (!user.getPhone().trim().isEmpty()) {
                if (userServise.existsByPhone(user.getPhone())) {
                    bindingResult.addError(new ObjectError("phone", "phone already exists for this email."));
                }
            }
            if (!user.getEmail().trim().isEmpty()) {
                if (userServise.existsByEmail(user.getEmail())) {
                    bindingResult.addError(new ObjectError("email", "email1 already exists for this email."));
                }
            }
        }
        if (bindingResult.hasErrors()) {
            return "/registration";
        }
        userServise.addUser(user);
        return "/index";
    }


}
